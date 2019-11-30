package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@Table(name = "usr")
public class User extends AbstractAuditEntity {
    @Column(length = USERNAME_MAX, nullable = false, unique = true)
    private String username;

    @Column(length = PASSWORD_HASH_MAX, nullable = false)
    private String password;

    @Column(length = FIRST_NAME_MAX)
    private String firstName;

    @Column(length = LAST_NAME_MAX)
    private String lastName;

    @Column(length = MIDDLE_NAME_MAX)
    private String middleName;

    @Enumerated
    @Column(nullable = false)
    private Role role;

    @Enumerated
    @ElementCollection
    @CollectionTable(
            uniqueConstraints = @UniqueConstraint(
                    name = "UX_userId_departments",
                    columnNames = {"user_id", "departments"}),
            indexes = @Index(
                    name = "IX_departments",
                    columnList = "departments"))
    private Set<Department> departments;
}
