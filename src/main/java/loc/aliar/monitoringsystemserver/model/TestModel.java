package loc.aliar.monitoringsystemserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestModel implements CreateDatable {
    private String type = "test";

    private String name;

    @JsonInclude(NON_NULL)
    private Long id;

    @JsonInclude(NON_NULL)
    private Long attemptId;

    @JsonInclude(NON_NULL)
    private LocalDateTime createdDate;

    @JsonInclude(NON_NULL)
    private List<QuestionModel> questions;

    interface View {
        interface Detailed {
        }

        interface List {
        }
    }
}
