package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
public class Patient extends AbstractEntity implements SetUserAble {
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @MapsId
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(optional = false)
    private Doctor doctor;
}
