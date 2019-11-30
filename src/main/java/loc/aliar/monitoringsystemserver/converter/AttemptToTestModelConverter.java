package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.AbstractEntity;
import loc.aliar.monitoringsystemserver.domain.test.TestAttempt;
import loc.aliar.monitoringsystemserver.model.AnswerModel;
import loc.aliar.monitoringsystemserver.model.QuestionModel;
import loc.aliar.monitoringsystemserver.model.TestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AttemptToTestModelConverter implements Converter<TestAttempt, TestModel> {
    private final TestToModelConverter testConverter;
    private final UserToModelConverter userConverter;

    @Override
    public TestModel convert(TestAttempt attempt) {
        TestModel model = testConverter.convert(attempt.getTest());

        if (model == null) {
            return null;
        }

        model.setAttemptId(attempt.getId());
        model.setCreatedDate(attempt.getCreatedDate().orElse(null));

        setCheckedAnswers(model, attempt);

        return model;
    }

    private void setCheckedAnswers(TestModel model, TestAttempt attempt) {
        List<QuestionModel> questions = model.getQuestions();

        if (questions == null) {
            return;
        }

        Set<Long> answerIds = attempt.getAnswers().stream()
                .map(AbstractEntity::getId)
                .collect(Collectors.toSet());

        for (QuestionModel question : questions) {
            List<AnswerModel> answers = question.getAnswers();
            for (AnswerModel answer : answers) {
                if (answerIds.contains(answer.getId())) {
                    answer.setChecked(true);
                }
            }
        }
    }
}
