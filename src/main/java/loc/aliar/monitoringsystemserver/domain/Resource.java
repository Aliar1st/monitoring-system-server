package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Resource extends AbstractAuditEntity {
    private String name;

    private String path;

    private Department department;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean visible;
}
