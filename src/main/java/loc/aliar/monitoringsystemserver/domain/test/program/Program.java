package loc.aliar.monitoringsystemserver.domain.test.program;

import loc.aliar.monitoringsystemserver.domain.AbstractEntity;
import loc.aliar.monitoringsystemserver.domain.Resource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"number", "type"}))
public class Program extends AbstractEntity {
    @Embedded
    private ProgramKey key;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Resource resource;
}
