package loc.aliar.monitoringsystemserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerModel {
    private String name;

    @JsonInclude(NON_NULL)
    private Long id;

    @JsonInclude(NON_NULL)
    private Boolean checked;
}
