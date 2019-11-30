package loc.aliar.monitoringsystemserver.service.admin;

import loc.aliar.monitoringsystemserver.domain.Admin;
import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.model.admin.AdminModel;

import java.util.List;

public interface AdminService extends CrudUserService<Admin, AdminModel> {
    List<AdminModel> getByDepartment(Department department);
}
