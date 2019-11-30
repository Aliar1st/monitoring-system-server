package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> getAllByDepartmentAndVisibleTrue(Department department);
}
