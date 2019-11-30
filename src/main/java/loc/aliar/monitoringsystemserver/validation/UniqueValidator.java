package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.validation.annotation.Unique;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class UniqueValidator implements ConstraintValidator<Unique, Object> {
    private static final String EXISTS_METHOD_PREFIX = "existsBy";

    private final ApplicationContext context;

    private CrudRepository<?, Long> repository;
    private String fieldName;
    private Class<?> fieldClass;

    @Override
    public void initialize(Unique constraint) {
        repository = context.getBean(constraint.value());
        fieldName = constraint.fieldName();
        fieldName = StringUtils.capitalize(fieldName);
        fieldClass = constraint.fieldClass();
    }

    @Override
    @SneakyThrows
    public boolean isValid(Object fieldValue, ConstraintValidatorContext context) {
        if (!ObjectUtils.isEmpty(fieldValue)) {
            return true;
        }

        String methodName = EXISTS_METHOD_PREFIX + fieldName;
        Method existsMethod = repository.getClass().getMethod(methodName, fieldClass);

        return !Boolean.class.cast(existsMethod.invoke(repository, fieldValue));
    }
}
