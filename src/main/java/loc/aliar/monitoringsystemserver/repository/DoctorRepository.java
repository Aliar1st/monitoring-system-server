package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Doctor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @EntityGraph(attributePaths = {"user"})
    List<Doctor> getAllByUserDepartmentsContains(Department departments);
}
