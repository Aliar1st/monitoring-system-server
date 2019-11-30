package loc.aliar.monitoringsystemserver.model.form.form;

import loc.aliar.monitoringsystemserver.model.form.FormType;

public interface Form {
    Long getTargetUserId();

    FormType getFormType();
}
