package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.form.FormAttempt;
import loc.aliar.monitoringsystemserver.model.form.FormModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AttemptToFormModelConverter implements Converter<FormAttempt, FormModel> {
    @Override
    public FormModel convert(FormAttempt formAttempt) {
        return FormModel.builder()
                .attemptId(formAttempt.getId())
                .formType(formAttempt.getType())
                .createdDate(formAttempt.getCreatedDate().orElse(null))
                .build();
    }
}
