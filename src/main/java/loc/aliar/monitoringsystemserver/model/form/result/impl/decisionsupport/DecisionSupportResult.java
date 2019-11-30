package loc.aliar.monitoringsystemserver.model.form.result.impl.decisionsupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.PatientProfileType;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@Setter
@Builder
public class DecisionSupportResult implements FormResult {
    private String firstName;
    private String lastName;
    private String middleName;
    private Byte age;
    private String mkb10Code;
    private Byte shrm;
    private PatientProfileType patientProfileType;
    private ResultType type;

    @JsonInclude(Include.NON_NULL)
    private Byte indicatedStep;

    @JsonInclude(Include.NON_NULL)
    private List<String> contraindications;

    @JsonInclude(Include.NON_NULL)
    private List<String> examinations;
}
