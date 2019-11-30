package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.test.Test;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface TestRepository extends JpaRepository<Test, Long> {
//    @EntityGraph(Test.NEG_TQA)
//    List<Test> getByDepartment(Department department);

    @Override
    @EntityGraph(Test.EG_TQA)
    Optional<Test> findById(Long id);
}
