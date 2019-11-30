package loc.aliar.monitoringsystemserver.validation.annotation;

import loc.aliar.monitoringsystemserver.validation.HasAccessToDepartmentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HasAccessToDepartmentValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HasAccessToDepartment {
    String message() default "{loc.aliar.monitoringsystem.validation.annotation.HasAccessToDepartment.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
