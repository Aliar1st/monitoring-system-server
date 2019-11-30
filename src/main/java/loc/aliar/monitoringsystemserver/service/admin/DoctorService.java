package loc.aliar.monitoringsystemserver.service.admin;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Doctor;
import loc.aliar.monitoringsystemserver.model.admin.DoctorModel;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;

import java.util.List;

public interface DoctorService extends CrudUserService<Doctor, DoctorModel> {
    List<DoctorModel> getByDepartment(Department department);

    List<PatientModel> getDoctorsPatients();

    boolean isDoctorsPatient(Long patientId);
}
