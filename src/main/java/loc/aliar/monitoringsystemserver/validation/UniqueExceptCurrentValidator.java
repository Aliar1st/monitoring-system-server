package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.util.ReflectionUtils;
import loc.aliar.monitoringsystemserver.validation.annotation.UniqueExceptCurrent;
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
public class UniqueExceptCurrentValidator implements ConstraintValidator<UniqueExceptCurrent, Object> {
    private static final String EXISTS_METHOD_PREFIX = "existsBy";
    private static final String EXISTS_METHOD_SUFFIX = "AndIdNot";

    private final ApplicationContext context;

    private CrudRepository<?, Long> repository;
    private String idFieldName;
    private String fieldName;
    private Class<?> fieldClass;

    @Override
    public void initialize(UniqueExceptCurrent constraint) {
        repository = context.getBean(constraint.value());
        idFieldName = constraint.idFieldName();
        fieldName = constraint.uniqueFieldName();
        fieldName = StringUtils.capitalize(fieldName);
        fieldClass = constraint.uniqueFieldClass();
    }

    @Override
    @SneakyThrows
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (!ObjectUtils.isEmpty(object)) {
            return true;
        }

        Long id = ReflectionUtils.getFieldValue(object, idFieldName, Long.class);
        Object value = ReflectionUtils.getFieldValue(object, fieldName);

        if (id == null || value == null) {
            return false;
        }

        String methodName = EXISTS_METHOD_PREFIX + fieldName + EXISTS_METHOD_SUFFIX;
        Method existsMethod = repository.getClass().getMethod(methodName, fieldClass, Long.class);

        return !Boolean.class.cast(existsMethod.invoke(repository, value, id));
    }
}
