package loc.aliar.monitoringsystemserver.service.test.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.test.Answer;
import loc.aliar.monitoringsystemserver.domain.test.TestProcessType;
import loc.aliar.monitoringsystemserver.model.test.TargetTestType;
import loc.aliar.monitoringsystemserver.model.test.result.impl.RecommendationPerAnswerTestResult;
import loc.aliar.monitoringsystemserver.repository.TestAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.test.BaseTestProcessor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@TargetTestType(TestProcessType.RECOMMENDATION_PER_ANSWER)
public class RecommendationPerAnswerTestProcessor extends BaseTestProcessor<RecommendationPerAnswerTestResult> {
    public RecommendationPerAnswerTestProcessor(TestRepository repository,
                                                TestAttemptRepository testAttemptRepository,
                                                UserRepository userRepository,
                                                ObjectMapper objectMapper,
                                                SecurityService securityService) {
        super(repository, testAttemptRepository, userRepository, objectMapper, securityService);
    }

    // TODO: 11/29/2019 DELETE TEST METHOD
//    @PostConstruct
//    private void test() throws InterruptedException {
//        User u = new User();
//        u.setId(2L);
//        Authentication a = new JwtAuthenticationToken(u, "", Role.DOCTOR);
//        SecurityContextHolder.getContext().setAuthentication(a);
//        process(5L, new HashSet<>(Arrays.asList(59L, 61L, 63L, 65L, 67L, 69L,
//                71L, 73L, 75L, 77L, 79L, 81L, 83L, 85L, 87L, 89L, 91L, 93L, 95L)), 1L);
//        Thread.sleep(1000);
//        process(5L, new HashSet<>(Arrays.asList(59L, 61L, 63L, 65L, 67L, 69L,
//                71L, 73L, 75L, 77L, 79L, 81L, 83L, 85L, 87L, 89L, 91L, 93L, 95L)), 1L);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//    }

    @Override
    protected RecommendationPerAnswerTestResult handle(Set<Answer> answers) {
        List<String> recommendations = answers.stream()
                .map(this::getRecommendations)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return RecommendationPerAnswerTestResult.builder()
                .recommendations(recommendations)
                .build();
    }

    @SneakyThrows
    private List<String> getRecommendations(Answer answer) {
        return objectMapper.readValue(answer.getData(), Recommendations.class).getRecommendations();
    }

    @Getter
    private static class Recommendations {
        private List<String> recommendations = Collections.emptyList();
    }
}
