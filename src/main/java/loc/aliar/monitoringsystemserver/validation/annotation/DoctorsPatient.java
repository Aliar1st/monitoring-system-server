package loc.aliar.monitoringsystemserver.validation.annotation;

import loc.aliar.monitoringsystemserver.validation.DoctorsPatientValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DoctorsPatientValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoctorsPatient {
    String message() default "{loc.aliar.monitoringsystem.validation.annotation.DoctorsPatient.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
