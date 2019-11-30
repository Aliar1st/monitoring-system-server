package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.validation.annotation.NotNullIfAnyOfRole;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@RequiredArgsConstructor
public class NotNullIfAnyOfRoleValidator implements ConstraintValidator<NotNullIfAnyOfRole, Object> {
    private final SecurityService securityService;

    private Role[] anyOf;

    @Override
    public void initialize(NotNullIfAnyOfRole constraint) {
        anyOf = constraint.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Role currentRole = securityService.getCurrentUser().getRole();
        if (!Arrays.asList(anyOf).contains(currentRole)) {
            return true;
        }
        return value != null;
    }
}
