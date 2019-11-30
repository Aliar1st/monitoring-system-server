package loc.aliar.monitoringsystemserver.service.test.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.test.Answer;
import loc.aliar.monitoringsystemserver.domain.test.TestProcessType;
import loc.aliar.monitoringsystemserver.model.test.TargetTestType;
import loc.aliar.monitoringsystemserver.model.test.result.impl.MaxScoreTestResult;
import loc.aliar.monitoringsystemserver.repository.TestAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.test.BaseTestProcessor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@TargetTestType(TestProcessType.MAX_SCORE)
public class MaxScoreTestProcessor extends BaseTestProcessor<MaxScoreTestResult> {
    public MaxScoreTestProcessor(TestRepository repository,
                                 TestAttemptRepository testAttemptRepository,
                                 UserRepository userRepository,
                                 ObjectMapper objectMapper,
                                 SecurityService securityService) {
        super(repository, testAttemptRepository, userRepository, objectMapper, securityService);
    }

    @Override
    protected MaxScoreTestResult handle(Set<Answer> answers) {
        if (answers.isEmpty()) {
            return MaxScoreTestResult.builder().build();
        }

        int maxScore = answers.stream()
                .mapToInt(this::getScore)
                .max().getAsInt();

        return MaxScoreTestResult.builder()
                .maxScore(maxScore)
                .build();
    }

    @SneakyThrows
    private int getScore(Answer answer) {
        return objectMapper.readValue(answer.getData(), Score.class).getScore();
    }

    @Getter
    private static class Score {
        private int score;
    }
}
