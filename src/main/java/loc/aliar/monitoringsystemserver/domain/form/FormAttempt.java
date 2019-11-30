package loc.aliar.monitoringsystemserver.domain.form;

import loc.aliar.monitoringsystemserver.domain.AbstractAuditEntity;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FormAttempt extends AbstractAuditEntity {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User passedUser;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User targetUser;

    @Enumerated
    private FormType type;

    @Column(length = 500, nullable = false)
    private String formBody;
}
