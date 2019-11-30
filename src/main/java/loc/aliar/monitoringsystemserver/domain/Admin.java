package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
public class Admin extends AbstractEntity implements SetUserAble {
    @MapsId
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
}
