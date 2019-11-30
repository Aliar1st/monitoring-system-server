package loc.aliar.monitoringsystemserver.service.doctor.base;

import loc.aliar.monitoringsystemserver.domain.test.Test;
import loc.aliar.monitoringsystemserver.domain.test.TestAttempt;
import loc.aliar.monitoringsystemserver.domain.test.TestType;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.model.TestModel;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import loc.aliar.monitoringsystemserver.repository.TestAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.service.doctor.TestService;
import loc.aliar.monitoringsystemserver.service.test.TestProcessorLocator;
import loc.aliar.monitoringsystemserver.util.AssertUtils;
import loc.aliar.monitoringsystemserver.util.ConverterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BaseTestService implements TestService {
    private final TestRepository repository;
    private final TestAttemptRepository testAttemptRepository;
    private final TestProcessorLocator processorLocator;
    private final ConversionService conversionService;

    @Override
    public TestModel getByType(String type) {
        Test test = findByType(type);
        return conversionService.convert(test, TestModel.class);
    }

    private Test findByType(String type) {
        Long id = TestType.byType(type).getId();
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException.of(Test.class, id));
    }

    @Override
    public TestResult process(String type, Set<Long> ids, Long targetUserId) {
        Test test = findByType(type);
        return processorLocator.byType(test.getTestProcessType())
                .process(test, ids, targetUserId);
    }

    @Override
    public TestResult processAttempt(Long attemptId) {
        AssertUtils.checkIdValid(attemptId);
        TestAttempt attempt = testAttemptRepository.findById(attemptId)
                .orElseThrow(EntityNotFoundException.of(TestAttempt.class, attemptId));
        return processAttempt(attempt);
    }

    private TestResult processAttempt(TestAttempt attempt) {
        return processorLocator.byType(attempt.getTest().getTestProcessType())
                .processAttempt(attempt);
    }

    @Override
    public TestModel getByAttempt(Long attemptId) {
        AssertUtils.checkIdValid(attemptId);
        TestAttempt attempt = testAttemptRepository.findById(attemptId)
                .orElseThrow(EntityNotFoundException.of(TestAttempt.class, attemptId));
        return conversionService.convert(attempt, TestModel.class);
    }
    // TODO: 11/29/2019 DELETE
//    @PostConstruct
//    public void test() {
//        TestModel byTargetUserId = getByAttempt(1L);
//        System.out.println();
//    }

    @Override
    public List<TestModel> getByTargetUserId(Long targetUserId) {
        AssertUtils.checkIdValid(targetUserId);
        List<TestAttempt> attempts = testAttemptRepository.getAllByTargetUserIdAndTestVisibleTrueOrderByCreatedDateDesc(targetUserId);
        return ConverterUtils.convertList(attempts, TestModel.class, conversionService);
    }

//    @PostConstruct
//    public void test() {
//        List<TestAttemptSummary> allByTargetUserId = testAttemptRepository.getAllByTargetUserId(1L);
//    }

    @Override
    public TestResult getLastByTargetUserId(String type, Long targetUserId) {
        TestType testType = TestType.byType(type);
        TestAttempt attempt = testAttemptRepository
                .getFirstByTestIdAndTargetUserIdAndTestVisibleTrueOrderByCreatedDateDesc(
                        testType.getId(), targetUserId)
                .orElseThrow(EntityNotFoundException.of(TestAttempt.class, testType.name()));
        return processAttempt(attempt);
    }

    // TODO: 11/29/2019 DELETE
//    @PostConstruct
//    public void test() {
//        Object byTargetUserId = getLastByTargetUserId(TestType.KNEE_ENDOPROSTHESIS.name(), 3L);
//        System.out.println();
//    }
}
