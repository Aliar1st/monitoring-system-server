package loc.aliar.monitoringsystemserver.model;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String username;
    private Role role;
    private Set<Department> departments;
    private String firstName;
    private String lastName;
    private String middleName;
}
