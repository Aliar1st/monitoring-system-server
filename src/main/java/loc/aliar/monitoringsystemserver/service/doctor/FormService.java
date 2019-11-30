package loc.aliar.monitoringsystemserver.service.doctor;

import loc.aliar.monitoringsystemserver.model.form.FormModel;
import loc.aliar.monitoringsystemserver.model.form.form.Form;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;

import java.util.List;

public interface FormService {
    FormResult process(String type, Form form);

    FormResult processAttempt(Long attemptId);

//    TestModel getByAttempt(Long attemptId);

    List<FormModel> getByTargetUserId(Long targetUserId);

    FormResult getLastByTargetUserId(String type, Long targetUserId);
}
