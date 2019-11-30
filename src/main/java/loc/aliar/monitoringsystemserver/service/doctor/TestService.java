package loc.aliar.monitoringsystemserver.service.doctor;

import loc.aliar.monitoringsystemserver.model.TestModel;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;

import java.util.List;
import java.util.Set;

public interface TestService {
    TestModel getByType(String type);

    TestResult process(String type, Set<Long> ids, Long targetUserId);

    TestResult processAttempt(Long attemptId);

    TestModel getByAttempt(Long attemptId);

    List<TestModel> getByTargetUserId(Long targetUserId);

    TestResult getLastByTargetUserId(String type, Long targetUserId);
}
