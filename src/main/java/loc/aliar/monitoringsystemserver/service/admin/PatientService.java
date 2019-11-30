package loc.aliar.monitoringsystemserver.service.admin;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Patient;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;

import java.util.List;

public interface PatientService extends CrudUserService<Patient, PatientModel> {
    List<PatientModel> getByDepartment(Department department);
}
