package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.util.AssertUtils;
import loc.aliar.monitoringsystemserver.validation.annotation.Exists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ExistsValidatorForLong implements ConstraintValidator<Exists, Long> {
    private final ApplicationContext context;

    private CrudRepository<?, Long> repository;

    @Override
    public void initialize(Exists constraint) {
        //noinspection unchecked
        repository = (CrudRepository<?, Long>) context.getBean(constraint.value());
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id == null) {
            return true;
        }
        return AssertUtils.isIdValid(id) && repository.existsById(id);
    }
}
