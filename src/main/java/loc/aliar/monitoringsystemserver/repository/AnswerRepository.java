package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.test.Answer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Override
    @EntityGraph(attributePaths = "recommendation")
    List<Answer> findAllById(Iterable<Long> longs);
}
