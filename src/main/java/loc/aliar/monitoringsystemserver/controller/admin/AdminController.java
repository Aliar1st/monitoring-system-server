package loc.aliar.monitoringsystemserver.controller.admin;

import loc.aliar.monitoringsystemserver.domain.Admin;
import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.model.admin.AdminModel;
import loc.aliar.monitoringsystemserver.model.admin.Validation;
import loc.aliar.monitoringsystemserver.model.request.ChangePasswordRequest;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.AdminService;
import loc.aliar.monitoringsystemserver.service.admin.CrudService;
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
@RequestMapping("admin/admin")
public class AdminController extends CrudController<Admin, AdminModel> {
    private final AdminService service;
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

        List<AdminModel> models = service.getByDepartment(department);
        return ResponseEntity.ok(models);
    }

//    @PostConstruct
//    void test() {
//        User user = new User(1L);
//        user.setDepartments(Collections.singleton(Department.GLOBAL));
//        Authentication a = new JwtAuthenticationToken(user, "", Role.SUPER_ADMIN);
//        SecurityContextHolder.getContext().setAuthentication(a);
//
//        readByDepartment("GLOBAL");
//    }

    @PostMapping
    public ResponseEntity<?> create(@Validated({Validation.Create.class, Default.class})
                                    @RequestBody AdminModel model) {
        return super.create(model);
    }

    @PutMapping("{id}")
    @PreAuthorize("id == model.id")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @Validated({Validation.Update.class, Default.class})
                                    @RequestBody AdminModel model) {
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
    protected CrudService<Admin, AdminModel> getCrudService() {
        return service;
    }
}
