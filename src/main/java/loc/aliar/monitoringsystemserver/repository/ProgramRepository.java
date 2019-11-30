package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.test.program.Program;
import loc.aliar.monitoringsystemserver.domain.test.program.ProgramKey;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional(readOnly = true)
public interface ProgramRepository extends JpaRepository<Program, Long> {
    @EntityGraph(attributePaths = "resource")
    Program getByKey(ProgramKey key);

    @EntityGraph(attributePaths = "resource")
    List<Program> getAllByKeyIn(Collection<ProgramKey> keys);
}
