package loc.aliar.monitoringsystemserver.controller.doctor;

import loc.aliar.monitoringsystemserver.model.TestModel;
import loc.aliar.monitoringsystemserver.model.request.TestProcessRequest;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import loc.aliar.monitoringsystemserver.service.doctor.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@RestController
@RequestMapping("doctor/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping("{type}")
    public ResponseEntity<?> readByName(@PathVariable String type) {
        TestModel testModel = service.getByType(type);
        return ResponseEntity.ok(testModel);
    }

    @PostMapping("{type}")
    public ResponseEntity<?> process(@PathVariable String type, @RequestBody @Valid TestProcessRequest request) {
        TestResult result = service.process(type, new HashSet<>(request.getAnswerIds()), request.getPatientId());
        return ResponseEntity.ok(result);
    }
}
