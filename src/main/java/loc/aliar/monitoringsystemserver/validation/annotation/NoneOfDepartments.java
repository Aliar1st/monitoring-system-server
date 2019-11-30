package loc.aliar.monitoringsystemserver.validation.annotation;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.validation.NoneOfDepartmentsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoneOfDepartmentsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoneOfDepartments {
    Department[] value() default Department.GLOBAL;

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.NoneOfDepartments.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
