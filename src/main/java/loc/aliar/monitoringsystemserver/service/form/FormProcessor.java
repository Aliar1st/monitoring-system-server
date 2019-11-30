package loc.aliar.monitoringsystemserver.service.form;

import loc.aliar.monitoringsystemserver.domain.form.FormAttempt;
import loc.aliar.monitoringsystemserver.model.form.form.Form;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FormProcessor<F extends Form, R extends FormResult> {

    R process(F form);

    R processAttempt(FormAttempt attempt);
}
