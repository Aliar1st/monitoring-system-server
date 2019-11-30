package loc.aliar.monitoringsystemserver.validation.annotation;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.validation.NotNullIfAnyOfRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotNullIfAnyOfRoleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullIfAnyOfRole {
    Role[] value() default Role.SUPER_ADMIN;

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.NotNullIfRole.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
