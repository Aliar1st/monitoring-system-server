package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.service.admin.DoctorService;
import loc.aliar.monitoringsystemserver.util.AssertUtils;
import loc.aliar.monitoringsystemserver.validation.annotation.DoctorsPatient;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class DoctorsPatientValidator implements ConstraintValidator<DoctorsPatient, Long> {
    private final DoctorService doctorService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return AssertUtils.isIdValid(value) && doctorService.isDoctorsPatient(value);
    }
}
