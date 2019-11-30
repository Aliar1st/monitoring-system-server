package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.MEDICAL_INSTITUTION_MAX;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
public class Doctor extends AbstractEntity implements SetUserAble {
    @Column(length = MEDICAL_INSTITUTION_MAX, nullable = false)
    private String medicalInstitution;

    @MapsId
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Doctor(Long id) {
        setId(id);
    }
}
