package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.test.Question;
import loc.aliar.monitoringsystemserver.model.QuestionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionToModelConverter implements Converter<Question, QuestionModel> {
    private final AnswerToModelConverter answerConverter;

    @Override
    public QuestionModel convert(Question question) {
        return QuestionModel.builder()
                .name(question.getName())
                .answers(question.getAnswers().stream()
                        .map(answerConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }
}
