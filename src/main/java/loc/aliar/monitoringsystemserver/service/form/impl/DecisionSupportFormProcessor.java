package loc.aliar.monitoringsystemserver.service.form.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.Mkb10;
import loc.aliar.monitoringsystemserver.domain.test.Test;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import loc.aliar.monitoringsystemserver.model.form.TargetFormType;
import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.DecisionSupportForm;
import loc.aliar.monitoringsystemserver.model.form.result.impl.decisionsupport.DecisionSupportResult;
import loc.aliar.monitoringsystemserver.model.form.result.impl.decisionsupport.ResultType;
import loc.aliar.monitoringsystemserver.model.test.result.impl.MaxScoreTestResult;
import loc.aliar.monitoringsystemserver.model.test.result.impl.RecommendationPerAnswerTestResult;
import loc.aliar.monitoringsystemserver.repository.FormAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.Mkb10Repository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.PatientService;
import loc.aliar.monitoringsystemserver.service.form.BaseFormProcessor;
import loc.aliar.monitoringsystemserver.service.test.TestProcessorLocator;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@TargetFormType(FormType.DECISION_SUPPORT)
public class DecisionSupportFormProcessor extends BaseFormProcessor<DecisionSupportForm, DecisionSupportResult> {
    private static final Long REQUIRED_TEST_ID = 5L;

    private final Mkb10Repository mkb10Repository;
    private final TestRepository testRepository;
    private final PatientService patientService;
    private final TestProcessorLocator testProcessorLocator;

    public DecisionSupportFormProcessor(FormAttemptRepository formAttemptRepository,
                                        SecurityService securityService,
                                        ObjectMapper objectMapper,
                                        Mkb10Repository mkb10Repository,
                                        TestRepository testRepository,
                                        PatientService patientService,
                                        TestProcessorLocator testProcessorLocator,
                                        UserRepository userRepository) {
        super(formAttemptRepository, userRepository, securityService, objectMapper);
        this.mkb10Repository = mkb10Repository;
        this.testRepository = testRepository;
        this.patientService = patientService;
        this.testProcessorLocator = testProcessorLocator;
    }

    @Override
    public DecisionSupportResult handle(DecisionSupportForm form) {
        List<Test> tests = getRequiredTests(form);

        Test shrmTest = findById(tests, form.getPatientProfileType().getTest().getId());
        Byte shrm = getShrm(shrmTest, form.getAnswerIds(), form.getPatientId());

        Test contraindicationsTest = findById(tests, REQUIRED_TEST_ID);
        List<String> contraindications = getContraindications(
                contraindicationsTest, form.getAnswerIds(), form.getPatientId());

        Test examinationsTest = findById(tests, form.getSpecialistType().getTest().getId());
        List<String> examinations = getExaminations(
                examinationsTest, form.getAnswerIds(), form.getPatientId());

        Mkb10 mkb10 = mkb10Repository.findById(form.getMkb10Id())
                .orElseThrow(EntityNotFoundException.of(Mkb10.class, form.getMkb10Id()));

        PatientModel patient = patientService.get(form.getPatientId());

        int age = Period.between(patient.getDateOfBirth(), LocalDate.now()).getYears();

        return DecisionSupportResult.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .middleName(patient.getMiddleName())
                .age((byte) age)
                .mkb10Code(mkb10.getCode())
                .shrm(shrm)
                .patientProfileType(form.getPatientProfileType())
                .type(getType(contraindications, examinations))
                .indicatedStep(getIndicatedStep(shrm))
                .contraindications(contraindications)
                .examinations(examinations)
                .build();
    }

    private List<Test> getRequiredTests(DecisionSupportForm form) {
        List<Long> testIds = new ArrayList<>(3);
        testIds.add(REQUIRED_TEST_ID);
        testIds.add(form.getPatientProfileType().getTest().getId());
        testIds.add(form.getSpecialistType().getTest().getId());

        return testRepository.findAllById(testIds);
    }

    private Test findById(List<Test> tests, Long id) {
        return tests.stream()
                .filter(test -> id.equals(test.getId()))
                .findAny()
                .orElseThrow(EntityNotFoundException.of(Test.class, id));
    }

    private Byte getShrm(Test shrmTest, Set<Long> answerIds, Long targetUserId) {
        MaxScoreTestResult shrmResult = (MaxScoreTestResult) testProcessorLocator
                .byType(shrmTest.getTestProcessType())
                .process(shrmTest, answerIds, targetUserId);

        return shrmResult.getMaxScore().byteValue();
    }

    private List<String> getContraindications(Test contraindicationsTest, Set<Long> answerIds, Long targetUserId) {
        RecommendationPerAnswerTestResult result = (RecommendationPerAnswerTestResult) testProcessorLocator
                .byType(contraindicationsTest.getTestProcessType())
                .process(contraindicationsTest, answerIds, targetUserId);

        return result.getRecommendations();
    }

    private List<String> getExaminations(Test examinationsTest, Set<Long> answerIds, Long targetUserId) {
        RecommendationPerAnswerTestResult result = (RecommendationPerAnswerTestResult) testProcessorLocator
                .byType(examinationsTest.getTestProcessType())
                .process(examinationsTest, answerIds, targetUserId);

        return result.getRecommendations();
    }

    private ResultType getType(List<String> contraindications, List<String> examinations) {
        if (!ObjectUtils.isEmpty(contraindications)) {
            return ResultType.CONTRAINDICATED;
        }
        if (!ObjectUtils.isEmpty(examinations)) {
            return ResultType.NOT_APPLICABLE;
        }
        return ResultType.INDICATED;
    }

    private Byte getIndicatedStep(Byte shrm) {
        if (shrm == 2) {
            return 3;
        }
        if (shrm >= 3 && shrm <= 5) {
            return 2;
        }
        return null;
    }
}
