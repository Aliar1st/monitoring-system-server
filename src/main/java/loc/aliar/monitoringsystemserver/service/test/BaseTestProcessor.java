package loc.aliar.monitoringsystemserver.service.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.test.Answer;
import loc.aliar.monitoringsystemserver.domain.test.Question;
import loc.aliar.monitoringsystemserver.domain.test.Test;
import loc.aliar.monitoringsystemserver.domain.test.TestAttempt;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.exception.TestValidationException;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import loc.aliar.monitoringsystemserver.repository.TestAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.util.AssertUtils;
import loc.aliar.monitoringsystemserver.util.LogUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CommonsLog
@RequiredArgsConstructor
public abstract class BaseTestProcessor<R extends TestResult> implements TestProcessor<R> {
    protected final TestRepository repository;
    protected final TestAttemptRepository testAttemptRepository;
    protected final UserRepository userRepository;
    protected final ObjectMapper objectMapper;
    protected final SecurityService securityService;

    @Override
    public R process(Long testId, Set<Long> answerIds, Long targetUserId) {
        AssertUtils.checkIdValid(testId);
        AssertUtils.checkIdValid(targetUserId);

        Test test = repository.findById(testId)
                .orElseThrow(EntityNotFoundException.of(Test.class, testId));
        return process(test, answerIds, targetUserId);
    }

    @Override
    public R process(Test test, Set<Long> answerIds, Long targetUserId) {
        AssertUtils.checkIdValid(targetUserId);
        LogUtils.debug(log, "Start processing test %d for user %d with answers %s",
                test.getId(), targetUserId, answerIds);

        Set<Answer> answers = validateAndMapAnswers(test, answerIds);
        saveUserAttempt(test, answers, targetUserId);
        return handle(answers);
    }

    private Set<Answer> validateAndMapAnswers(Test test, Set<Long> answerIds) {
        LogUtils.debug(log, "Start validating answers");

        Set<Answer> answers = new HashSet<>(answerIds.size());
        Iterable<Question> questions = test.getQuestions();
        for (Question q : questions) {
            List<Answer> questionAnswers = q.getAnswers().stream()
                    .filter(answer -> answerIds.contains(answer.getId()))
                    .collect(Collectors.toList());
            answers.addAll(questionAnswers);
            int count = questionAnswers.size();

            if (count < q.getMinAnswers() || count > q.getMaxAnswers()) {
                // TODO: Add validation for all questions
                RuntimeException exception = new TestValidationException("Test has wrong number of answers");
                LogUtils.error(log, exception, exception.getMessage());
                throw exception;
            }
        }
        return answers;
    }

    private void saveUserAttempt(Test test, Set<Answer> answers, Long targetUserId) {
        LogUtils.debug(log, "Start saving test attempt");

        TestAttempt testAttempt = new TestAttempt();
        testAttempt.setPassedUser(securityService.getCurrentUser());
        testAttempt.setTargetUser(userRepository.getOne(targetUserId));
        testAttempt.setTest(test);
        testAttempt.setAnswers(answers);
        testAttemptRepository.save(testAttempt);

        LogUtils.debug(log, "Saved test attempt id: %d", testAttempt.getId());
    }

    @Override
    public R processAttempt(TestAttempt testAttempt) {
        LogUtils.debug(log, "Start processing test attempt with id: %d", testAttempt.getId());
        return handle(testAttempt.getAnswers());
    }

    protected abstract R handle(Set<Answer> answers);
}
