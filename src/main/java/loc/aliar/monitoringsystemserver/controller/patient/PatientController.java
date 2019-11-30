package loc.aliar.monitoringsystemserver.controller.patient;

import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import loc.aliar.monitoringsystemserver.service.admin.PatientService;
import loc.aliar.monitoringsystemserver.service.doctor.FormService;
import loc.aliar.monitoringsystemserver.service.doctor.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService service;
    private final TestService testService;
    private final FormService formService;

    @GetMapping("{id}")
    @PreAuthorize("#baseSecurityService.currentUser.id = id")
    public ResponseEntity<?> read(@PathVariable Long id) {
        PatientModel patient = service.get(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("{id}/test/{testType}/last")
    @PreAuthorize("#baseSecurityService.currentUser.id = id")
    public ResponseEntity<?> readLastTest(@PathVariable Long id, @PathVariable String testType) {
        TestResult result = testService.getLastByTargetUserId(testType, id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}/form/{formType}/last")
    @PreAuthorize("#baseSecurityService.currentUser.id = id")
    public ResponseEntity<?> readLastForm(@PathVariable Long id, @PathVariable String formType) {
        FormResult result = formService.getLastByTargetUserId(formType, id);
        return ResponseEntity.ok(result);
    }
}
