package loc.aliar.monitoringsystemserver.controller.doctor;

import loc.aliar.monitoringsystemserver.model.CreateDatable;
import loc.aliar.monitoringsystemserver.model.TestModel;
import loc.aliar.monitoringsystemserver.model.admin.DoctorModel;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.model.form.FormModel;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import loc.aliar.monitoringsystemserver.service.admin.DoctorService;
import loc.aliar.monitoringsystemserver.service.doctor.FormService;
import loc.aliar.monitoringsystemserver.service.doctor.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService service;
    private final TestService testService;
    private final FormService formService;

    @GetMapping("{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        DoctorModel doctor = service.get(id);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("patient")
    public ResponseEntity<?> readPatients() {
        List<PatientModel> doctorsPatients = service.getDoctorsPatients();
        return ResponseEntity.ok(doctorsPatients);
    }

    @GetMapping("patient/test/{patientId}")
    public ResponseEntity<?> readPatientsTests(@PathVariable Long patientId) {
        List<TestModel> patientsTests = testService.getByTargetUserId(patientId);
        List<FormModel> patientsForms = formService.getByTargetUserId(patientId);
        List<CreateDatable> all = new ArrayList<>(patientsTests.size() + patientsForms.size());
        all.addAll(patientsTests);
        all.addAll(patientsForms);
        all.sort(Comparator.nullsLast(Comparator.comparing(CreateDatable::getCreatedDate)));
        return ResponseEntity.ok(all);
    }

    @GetMapping("patient/test/attempt/{attemptId}")
    public ResponseEntity<?> readTestAttempt(@PathVariable Long attemptId) {
        TestModel attempt = testService.getByAttempt(attemptId);
        return ResponseEntity.ok(attempt);
    }

    @GetMapping("patient/test/attempt/{attemptId}/process")
    public ResponseEntity<?> processTestAttempt(@PathVariable Long attemptId) {
        TestResult result = testService.processAttempt(attemptId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("patient/form/attempt/{attemptId}/process")
    public ResponseEntity<?> processFormAttempt(@PathVariable Long attemptId) {
        FormResult result = formService.processAttempt(attemptId);
        return ResponseEntity.ok(result);
    }
}
