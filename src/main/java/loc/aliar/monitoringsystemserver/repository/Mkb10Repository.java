package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.Mkb10;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.PatientProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface Mkb10Repository extends JpaRepository<Mkb10, Long> {
    List<Mkb10> getAllByPatientProfileTypesContains(PatientProfileType patientProfileType);
}
