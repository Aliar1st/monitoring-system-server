package loc.aliar.monitoringsystemserver.service.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.form.FormAttempt;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import loc.aliar.monitoringsystemserver.model.form.form.Form;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.DecisionSupportForm;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import loc.aliar.monitoringsystemserver.repository.FormAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;

import java.util.EnumMap;

@CommonsLog
@RequiredArgsConstructor
public abstract class BaseFormProcessor<F extends Form, R extends FormResult> implements FormProcessor<F, R> {
    private static final EnumMap<FormType, Class<? extends Form>> typeFormMap = new EnumMap<>(FormType.class);

    static {
        typeFormMap.put(FormType.DECISION_SUPPORT, DecisionSupportForm.class);
    }

    protected final FormAttemptRepository formAttemptRepository;
    protected final UserRepository userRepository;
    protected final SecurityService securityService;
    protected final ObjectMapper objectMapper;

    @Override
    public R process(F form) {
        saveUserAttempt(form);
        return handle(form);
    }

    @Override
    @SneakyThrows
    public R processAttempt(FormAttempt attempt) {
        Form form = objectMapper.readValue(attempt.getFormBody(), typeFormMap.get(attempt.getType()));
        //noinspection unchecked
        return handle((F) form);
    }

    @SneakyThrows
    private void saveUserAttempt(F form) {
        FormAttempt formAttempt = new FormAttempt();
        formAttempt.setPassedUser(securityService.getCurrentUser());
        formAttempt.setTargetUser(userRepository.getOne(form.getTargetUserId()));
        formAttempt.setFormBody(objectMapper.writeValueAsString(form));
        formAttempt.setType(form.getFormType());
        formAttemptRepository.save(formAttempt);
    }

    protected abstract R handle(F form);
}
