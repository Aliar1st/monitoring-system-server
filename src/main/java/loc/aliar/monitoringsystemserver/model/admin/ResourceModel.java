package loc.aliar.monitoringsystemserver.model.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import loc.aliar.monitoringsystemserver.domain.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
@Builder
public class ResourceModel implements IdAble {
    private Long id;
    private String name;
    private Department department;
    @JsonIgnore
    private Resource resource;
}
