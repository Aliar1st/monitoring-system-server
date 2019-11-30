package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.test.Answer;
import loc.aliar.monitoringsystemserver.model.AnswerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnswerToModelConverter implements Converter<Answer, AnswerModel> {
    @Override
    public AnswerModel convert(Answer answer) {
        return AnswerModel.builder()
                .id(answer.getId())
                .name(answer.getName())
                .build();
    }
}
