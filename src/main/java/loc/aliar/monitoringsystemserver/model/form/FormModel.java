package loc.aliar.monitoringsystemserver.model.form;

import loc.aliar.monitoringsystemserver.model.CreateDatable;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormModel implements CreateDatable {
    private String type = "form";
    private Long attemptId;
    private FormType formType;
    private LocalDateTime createdDate;
}
