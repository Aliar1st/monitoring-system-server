package loc.aliar.monitoringsystemserver.validation.annotation;

import loc.aliar.monitoringsystemserver.validation.NewUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NewUserValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NewUser {
    String idFieldName() default "id";

    String passwordFieldName() default "password";

    String uniqueFieldName() default "username";

    String fieldName() default "deFiNme";

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.NewUserPassword.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
