package loc.aliar.monitoringsystemserver.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramModel {
    private String name;
    private Long resourceId;
}
