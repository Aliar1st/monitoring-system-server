package loc.aliar.monitoringsystemserver.model.form;

import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;

public enum FormType {
    DECISION_SUPPORT,
    ;

    public static FormType byType(String type) {
        try {
            return FormType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw EntityNotFoundException.of(FormType.class, type).get();
        }
    }
}
