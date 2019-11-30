package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.form.FormAttempt;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface FormAttemptRepository extends JpaRepository<FormAttempt, Long> {
    List<FormAttempt> getAllByTargetUserIdOrderByCreatedDateDesc(Long targetUserId);

    Optional<FormAttempt> getFirstByTypeAndTargetUserIdOrderByCreatedDateDesc(FormType type, Long targetUserId);
}
