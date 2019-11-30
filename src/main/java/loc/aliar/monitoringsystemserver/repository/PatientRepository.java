package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @EntityGraph(attributePaths = {"user"})
    List<Patient> getAllByUserDepartmentsContains(Department departments);

    List<Patient> getAllByDoctorId(Long doctorId);

    @Override
    @EntityGraph(attributePaths = {"user"})
    Optional<Patient> findById(Long aLong);
}
