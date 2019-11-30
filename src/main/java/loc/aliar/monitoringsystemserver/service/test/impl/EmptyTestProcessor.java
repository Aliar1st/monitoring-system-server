package loc.aliar.monitoringsystemserver.service.test.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import loc.aliar.monitoringsystemserver.domain.test.Answer;
import loc.aliar.monitoringsystemserver.domain.test.TestProcessType;
import loc.aliar.monitoringsystemserver.model.test.TargetTestType;
import loc.aliar.monitoringsystemserver.model.test.result.impl.EmptyTestResult;
import loc.aliar.monitoringsystemserver.repository.TestAttemptRepository;
import loc.aliar.monitoringsystemserver.repository.TestRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.test.BaseTestProcessor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@TargetTestType(TestProcessType.NO_RESULT)
public class EmptyTestProcessor extends BaseTestProcessor<EmptyTestResult> {
    public EmptyTestProcessor(TestRepository repository,
                              TestAttemptRepository testAttemptRepository,
                              UserRepository userRepository,
                              ObjectMapper objectMapper,
                              SecurityService securityService) {
        super(repository, testAttemptRepository, userRepository, objectMapper, securityService);
    }

    @Override
    protected EmptyTestResult handle(Set<Answer> answers) {
        return new EmptyTestResult();
    }
}
