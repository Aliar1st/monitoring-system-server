package loc.aliar.monitoringsystemserver.controller;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {
    private final SecurityService securityService;

    @GetMapping("available")
    public ResponseEntity<?> readAvailable() {
        Set<Department> departments = securityService.getCurrentUser().getDepartments();
        return ResponseEntity.ok(Department.resolve(departments));
    }
}
