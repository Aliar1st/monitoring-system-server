package loc.aliar.monitoringsystemserver.validation.annotation;

import loc.aliar.monitoringsystemserver.validation.UniqueExceptCurrentValidator;
import org.springframework.data.repository.CrudRepository;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueExceptCurrentValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueExceptCurrent {
    Class<? extends CrudRepository<?, Long>> value();

    String idFieldName() default "id";

    String uniqueFieldName() default "name";

    Class<?> uniqueFieldClass() default String.class;

    String errorFieldName() default "name";

    String message() default "{loc.aliar.monitoringsystem.validation.annotation.UniqueForNew.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
