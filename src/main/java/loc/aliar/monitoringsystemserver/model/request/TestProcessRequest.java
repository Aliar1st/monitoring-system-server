package loc.aliar.monitoringsystemserver.model.request;

import loc.aliar.monitoringsystemserver.validation.annotation.DoctorsPatient;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class TestProcessRequest {
    @NotEmpty
    private List<@NotNull @Positive Long> answerIds;

    @NotNull
    @DoctorsPatient
    private Long patientId;
}
