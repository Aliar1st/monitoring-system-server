package loc.aliar.monitoringsystemserver.controller.admin;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Patient;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.model.admin.Validation;
import loc.aliar.monitoringsystemserver.model.request.ChangePasswordRequest;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.CrudService;
import loc.aliar.monitoringsystemserver.service.admin.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/patient")
public class AdminPatientController extends CrudController<Patient, PatientModel> {
    private final PatientService service;
    private final SecurityService securityService;

    @GetMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<?> read() {
        return super.read();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        return super.read(id);
    }

    @GetMapping("/department/{departmentName}")
    public ResponseEntity<?> readByDepartment(@PathVariable String departmentName) {
        Department department = Department.byType(departmentName);
        securityService.checkAccess(department);

        List<PatientModel> models = service.getByDepartment(department);
        return ResponseEntity.ok(models);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated({Validation.Create.class, Default.class})
                                    @RequestBody PatientModel model) {
        return super.create(model);
    }

    @PutMapping("{id}")
    @PreAuthorize("id == model.id")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @Validated({Validation.Update.class, Default.class})
                                    @RequestBody PatientModel model) {
        return super.update(id, model);
    }

    @PutMapping("{id}/changePassword")
    @PreAuthorize("id == request.userId")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @Valid ChangePasswordRequest request) {
        service.changePassword(request.getUserId(), request.getNewPassword());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    protected CrudService<Patient, PatientModel> getCrudService() {
        return service;
    }
}
