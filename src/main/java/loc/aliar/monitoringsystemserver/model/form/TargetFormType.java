package loc.aliar.monitoringsystemserver.model.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TargetFormType {
    FormType value();
}
