package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.util.ReflectionUtils;
import loc.aliar.monitoringsystemserver.validation.annotation.NewUser;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class NewUserValidator implements ConstraintValidator<NewUser, Object> {

    private String idFieldName;
    private String passwordFieldName;

    @Override
    public void initialize(NewUser constraintAnnotation) {
        this.idFieldName = constraintAnnotation.idFieldName();
        this.passwordFieldName = constraintAnnotation.passwordFieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return ReflectionUtils.getFieldValue(value, idFieldName) != null
                || ReflectionUtils.getFieldValue(value, passwordFieldName) != null;
    }
}
