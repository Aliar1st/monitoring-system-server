package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.test.Question;
import loc.aliar.monitoringsystemserver.domain.test.Test;
import loc.aliar.monitoringsystemserver.model.TestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TestToModelConverter implements Converter<Test, TestModel> {
    private final QuestionToModelConverter questionConverter;
    private final EntityManager entityManager;

    @Override
    public TestModel convert(Test test) {
        TestModel.TestModelBuilder testModelBuilder = TestModel.builder()
                .id(test.getId())
                .name(test.getName());

        Set<Question> questions = test.getQuestions();
        PersistenceUnitUtil persistenceUnitUtil = entityManager.getEntityManagerFactory().getPersistenceUnitUtil();
        if (persistenceUnitUtil.isLoaded(questions)) {
            testModelBuilder.questions(questions.stream()
                    .map(questionConverter::convert)
                    .collect(Collectors.toList()));
        }
        return testModelBuilder.build();
    }
}
