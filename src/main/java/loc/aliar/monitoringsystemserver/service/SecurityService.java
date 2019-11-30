package loc.aliar.monitoringsystemserver.service;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.User;

public interface SecurityService {
    User getCurrentUser();

    boolean hasAccess(Department department);

    void checkAccess(Department department);
}
