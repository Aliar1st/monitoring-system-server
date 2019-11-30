package loc.aliar.monitoringsystemserver.service.admin;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Resource;
import loc.aliar.monitoringsystemserver.model.admin.ResourceModel;

import java.util.List;

public interface ResourceService extends CrudService<Resource, ResourceModel> {
    List<ResourceModel> getByDepartment(Department department);

    ResourceModel getResource(Long id);
}
