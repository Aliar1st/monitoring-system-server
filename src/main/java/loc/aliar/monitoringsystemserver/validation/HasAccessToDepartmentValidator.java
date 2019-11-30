package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.validation.annotation.HasAccessToDepartment;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class HasAccessToDepartmentValidator implements ConstraintValidator<HasAccessToDepartment, Department> {
    private final SecurityService securityService;

    @Override
    public boolean isValid(Department value, ConstraintValidatorContext context) {
        return securityService.hasAccess(value);
    }
}
