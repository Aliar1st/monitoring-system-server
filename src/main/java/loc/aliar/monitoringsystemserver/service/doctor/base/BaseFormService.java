package loc.aliar.monitoringsystemserver.service.doctor.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.form.FormAttempt;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.model.form.FormModel;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import loc.aliar.monitoringsystemserver.model.form.form.Form;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import loc.aliar.monitoringsystemserver.repository.FormAttemptRepository;
import loc.aliar.monitoringsystemserver.service.doctor.FormService;
import loc.aliar.monitoringsystemserver.service.form.FormProcessorLocator;
import loc.aliar.monitoringsystemserver.util.AssertUtils;
import loc.aliar.monitoringsystemserver.util.ConverterUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseFormService implements FormService {
    private final FormAttemptRepository formAttemptRepository;
    private final FormProcessorLocator processorLocator;
    private final ConversionService conversionService;
    private final ObjectMapper objectMapper;

    @Override
    public FormResult process(String type, Form form) {
        FormType formType = FormType.byType(type);
        //noinspection unchecked
        return processorLocator.byType(formType)
                .process(form);
    }

    @Override
    public FormResult processAttempt(Long attemptId) {
        FormAttempt formAttempt = formAttemptRepository.findById(attemptId)
                .orElseThrow(EntityNotFoundException.of(FormAttempt.class, attemptId));
        return processAttempt(formAttempt);
    }
    @SneakyThrows
    private FormResult processAttempt(FormAttempt attempt) {
        return processorLocator.byType(attempt.getType())
                .processAttempt(attempt);
    }

    @Override
    public List<FormModel> getByTargetUserId(Long targetUserId) {
        AssertUtils.checkIdValid(targetUserId);
        List<FormAttempt> formAttempts = formAttemptRepository
                .getAllByTargetUserIdOrderByCreatedDateDesc(targetUserId);
        return ConverterUtils.convertList(formAttempts, FormModel.class, conversionService);
    }


    @Override
    public FormResult getLastByTargetUserId(String type, Long targetUserId) {
        FormType formType = FormType.byType(type);
        FormAttempt formAttempt = formAttemptRepository
                .getFirstByTypeAndTargetUserIdOrderByCreatedDateDesc(formType, targetUserId)
                .orElseThrow(EntityNotFoundException.of(FormAttempt.class, formType.name()));
        return processAttempt(formAttempt);
    }
}
