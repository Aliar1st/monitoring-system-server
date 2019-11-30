package loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport;

import loc.aliar.monitoringsystemserver.model.form.FormType;
import loc.aliar.monitoringsystemserver.model.form.form.Form;
import loc.aliar.monitoringsystemserver.repository.Mkb10Repository;
import loc.aliar.monitoringsystemserver.validation.annotation.DoctorsPatient;
import loc.aliar.monitoringsystemserver.validation.annotation.Exists;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Getter
@Setter
public class DecisionSupportForm implements Form {
    @NotNull
    private PatientProfileType patientProfileType;

    @NotNull
    @DoctorsPatient
    private Long patientId;

    @Exists(Mkb10Repository.class)
    private Long mkb10Id;

    @NotNull
    private SpecialistType specialistType;

    @NotNull
    private FormType formType;

    @NotEmpty
    private Set<@NotNull @Positive Long> answerIds;

    @Override
    public Long getTargetUserId() {
        return patientId;
    }
}
