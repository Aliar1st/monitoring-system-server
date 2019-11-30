package loc.aliar.monitoringsystemserver.controller.doctor;

import loc.aliar.monitoringsystemserver.domain.Mkb10;
import loc.aliar.monitoringsystemserver.domain.test.TestType;
import loc.aliar.monitoringsystemserver.model.Mkb10Model;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.DecisionSupportForm;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.PatientProfileType;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.SpecialistType;
import loc.aliar.monitoringsystemserver.model.form.result.FormResult;
import loc.aliar.monitoringsystemserver.repository.Mkb10Repository;
import loc.aliar.monitoringsystemserver.service.doctor.FormService;
import loc.aliar.monitoringsystemserver.util.ConverterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctor/form")
public class FormController {
    private final Mkb10Repository mkb10Repository;
    private final FormService formService;
    private final ConversionService conversionService;

    @GetMapping("{type}")
    public ResponseEntity<?> read(@PathVariable String type) {
        FormType formType = FormType.byType(type);
        if (formType == FormType.DECISION_SUPPORT) {
            Map<String, Object> response = new HashMap<>();
            response.put("patientProfileTypes", PatientProfileType.values());
            response.put("specialistTypes", SpecialistType.values());
            response.put("contraindicationsTest", TestType.DETERMINATION_CONTRAINDICATIONS);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{type}")
    public ResponseEntity<?> process(@PathVariable String type, @RequestBody @Valid DecisionSupportForm form) {
        FormResult result = formService.process(type, form);
        return ResponseEntity.ok(result);
    }

    @GetMapping("mkb10/{type}")
    public ResponseEntity<?> readMkb10(@PathVariable String type) {
        PatientProfileType patientProfileType = PatientProfileType.valueOf(type);
        List<Mkb10> mkb10s = mkb10Repository.getAllByPatientProfileTypesContains(patientProfileType);
        return ResponseEntity.ok(ConverterUtils.convertList(mkb10s, Mkb10Model.class, conversionService));
    }
}
