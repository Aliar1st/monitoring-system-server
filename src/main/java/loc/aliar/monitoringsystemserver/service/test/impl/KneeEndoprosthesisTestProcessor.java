package loc.aliar.monitoringsystemserver.service.test.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.test.Answer;
import loc.aliar.monitoringsystemserver.domain.test.TestProcessType;
import loc.aliar.monitoringsystemserver.domain.test.program.Program;
import loc.aliar.monitoringsystemserver.domain.test.program.ProgramKey;
import loc.aliar.monitoringsystemserver.model.ProgramModel;
import loc.aliar.monitoringsystemserver.model.test.TargetTestType;
import loc.aliar.monitoringsystemserver.model.test.result.impl.KneeEndoprosthesisTestResult;
import loc.aliar.monitoringsystemserver.repository.ProgramRepository;
import loc.aliar.monitoringsystemserver.repository.TestAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.test.BaseTestProcessor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
@CommonsLog
@TargetTestType(TestProcessType.KNEE_ENDOPROSTHESIS)
public class KneeEndoprosthesisTestProcessor extends BaseTestProcessor<KneeEndoprosthesisTestResult> {
    private final ProgramRepository programRepository;
    private final ConversionService conversionService;

    public KneeEndoprosthesisTestProcessor(TestRepository repository,
                                           TestAttemptRepository testAttemptRepository,
                                           UserRepository userRepository,
                                           ObjectMapper objectMapper,
                                           SecurityService securityService,
                                           ProgramRepository programRepository,
                                           ConversionService conversionService) {
        super(repository, testAttemptRepository, userRepository, objectMapper, securityService);
        this.programRepository = programRepository;
        this.conversionService = conversionService;
    }

//    @PostConstruct
//    public void test() {
//        User u = new User();
//        u.setId(3L);
//        Authentication a = new JwtAuthenticationToken(u, "", Role.PATIENT);
//        SecurityContextHolder.getContext().setAuthentication(a);
//        process(TestType.KNEE_ENDOPROSTHESIS.getId(), new HashSet<>(Arrays.asList(1L, 7L, 11L, 13L, 15L)), 3L);
//    }

    @Override
    protected KneeEndoprosthesisTestResult handle(Set<Answer> answers) {
        Map<Integer, Integer> programChoseNumber = new HashMap<>();
        Map<Integer, Integer> programChoseType = new HashMap<>();
        List<String> recommendations = new ArrayList<>();

        extractRecommendations(answers, programChoseNumber, programChoseType, recommendations);

        Set<Integer> chosenNumbers = getKeysWithMaxValue(programChoseNumber);
        Set<Integer> chosenTypes = getKeysWithMaxValue(programChoseType);

        List<ProgramModel> programModels = new ArrayList<>();
        for (Integer chosenType : chosenTypes) {
            for (Integer chosenNumber : chosenNumbers) {
                Program program = programRepository.getByKey(new ProgramKey(chosenNumber, chosenType));
                ProgramModel programModel = conversionService.convert(program, ProgramModel.class);
                programModels.add(programModel);
            }
        }

        return KneeEndoprosthesisTestResult.builder()
                .recommendations(recommendations)
                .programs(programModels)
                .build();
    }

    private void extractRecommendations(
            Set<Answer> answers,
            Map<Integer, Integer> numbers,
            Map<Integer, Integer> types,
            List<String> recommendations
    ) {
        for (Answer answer : answers) {
            Recommendation recommendation = getRecommendation(answer);
            switch (recommendation.getRecommendationType()) {
                case TEXT:
                    recommendations.add(recommendation.getRecommendation());
                    break;
                case PROGRAM_NUMBER:
                    numbers.compute(recommendation.getNumber(), ValueIncrement.getInstance());
                    break;
                case PROGRAM_TYPE:
                    types.compute(recommendation.getType(), ValueIncrement.getInstance());
                    break;
                default:
            }
        }
    }

    @SneakyThrows
    private Recommendation getRecommendation(Answer answer) {
        return objectMapper.readValue(answer.getData(), Recommendation.class);
    }

    private <T> Set<T> getKeysWithMaxValue(Map<T, Integer> map) {
        Integer max = Collections.max(map.values());
        return map.entrySet().stream()
                .filter(e -> max.equals(e.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Getter
    private static class Recommendation {
        private String recommendation;
        private Integer number;
        private Integer type;

        private RecommendationType getRecommendationType() {
            if (recommendation != null) {
                return RecommendationType.TEXT;
            } else if (number != null) {
                return RecommendationType.PROGRAM_NUMBER;
            } else if (type != null) {
                return RecommendationType.PROGRAM_TYPE;
            }
            return RecommendationType.NONE;
        }
    }

    private enum RecommendationType {
        NONE, TEXT, PROGRAM_NUMBER, PROGRAM_TYPE
    }

    private static class ValueIncrement implements BiFunction<Integer, Integer, Integer> {
        private static ValueIncrement instance = new ValueIncrement();

        private ValueIncrement() {
        }

        @Override
        public Integer apply(Integer k, Integer v) {
            return v == null ? 1 : v + 1;
        }

        private static ValueIncrement getInstance() {
            return instance;
        }
    }
}
