package loc.aliar.monitoringsystemserver.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditEntity extends AbstractEntity implements Auditable<User, Long, LocalDateTime> {
    @CreatedBy
    @ManyToOne(fetch = LAZY)
    private User createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    @ManyToOne(fetch = LAZY)
    private User lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public Optional<User> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.ofNullable(createdDate);
    }

    @Override
    public Optional<User> getLastModifiedBy() {
        return Optional.ofNullable(lastModifiedBy);
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.ofNullable(lastModifiedDate);
    }
}
