package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.Admin;
import loc.aliar.monitoringsystemserver.domain.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @EntityGraph(attributePaths = {"user", "user.departments"})
    List<Admin> getAllByUserDepartmentsContains(Department departments);
}
