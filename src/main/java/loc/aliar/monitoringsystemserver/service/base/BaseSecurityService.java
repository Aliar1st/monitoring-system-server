package loc.aliar.monitoringsystemserver.service.base;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.exception.UserNotAuthenticatedException;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BaseSecurityService implements SecurityService {
    @Override
    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        return Optional.ofNullable(context.getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(User.class::isInstance)
                .map(User.class::cast)
                .orElseThrow(UserNotAuthenticatedException::new);
    }

    @Override
    public boolean hasAccess(Department department) {
        Set<Department> departments = getCurrentUser().getDepartments();
        return departments.contains(Department.GLOBAL) ||
                departments.contains(department);
    }

    @Override
    public void checkAccess(Department department) {
        if (!hasAccess(department)) {
            throw new AccessDeniedException("Current user does not have access to " + department);
        }
    }
}
