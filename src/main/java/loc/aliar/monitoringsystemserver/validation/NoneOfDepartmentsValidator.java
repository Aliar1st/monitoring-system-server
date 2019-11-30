package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.validation.annotation.NoneOfDepartments;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@RequiredArgsConstructor
public class NoneOfDepartmentsValidator implements ConstraintValidator<NoneOfDepartments, Department> {
    private Department[] noneOf;

    @Override
    public void initialize(NoneOfDepartments constraint) {
        noneOf = constraint.value();
    }

    @Override
    public boolean isValid(Department department, ConstraintValidatorContext context) {
        return !Arrays.asList(noneOf).contains(department);
    }
}
