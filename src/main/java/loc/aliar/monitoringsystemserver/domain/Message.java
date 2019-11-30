package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Message extends AbstractAuditEntity {
    @Column(columnDefinition = "text", nullable = false)
    private String body;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean isRead;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User fromUser;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User toUser;
}
