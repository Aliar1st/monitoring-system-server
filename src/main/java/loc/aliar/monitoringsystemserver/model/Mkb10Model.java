package loc.aliar.monitoringsystemserver.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Mkb10Model {
    private Long id;
    private String code;
    private String name;
}
