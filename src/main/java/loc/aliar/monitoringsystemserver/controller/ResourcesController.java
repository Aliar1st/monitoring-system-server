package loc.aliar.monitoringsystemserver.controller;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.model.admin.ResourceModel;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("patient/resource")
@RequiredArgsConstructor
public class ResourcesController {
    private static final String DISPOSITION_TYPE = "attachment";

    private final ResourceService service;
    private final SecurityService securityService;

    @GetMapping
    public ResponseEntity<?> read() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        ResourceModel resource = service.getResource(id);
        String contentDisposition = ContentDisposition.builder(DISPOSITION_TYPE)
                .filename(resource.getName(), StandardCharsets.UTF_8)
                .build().toString();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource.getResource());
    }

    @GetMapping("/department/{departmentName}")
    public ResponseEntity<?> readByDepartment(@PathVariable String departmentName) {
        Department department = Department.byType(departmentName);
        securityService.checkAccess(department);

        List<ResourceModel> models = service.getByDepartment(department);
        return ResponseEntity.ok(models);
    }
}
