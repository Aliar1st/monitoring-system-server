package loc.aliar.monitoringsystemserver.service.test;

import loc.aliar.monitoringsystemserver.domain.test.Test;
import loc.aliar.monitoringsystemserver.domain.test.TestAttempt;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface TestProcessor<R extends TestResult> {
//    TestModel getTest(Department department);

    R process(Long testId, Set<Long> answerIds, Long targetUserId);

    R process(Test test, Set<Long> answerIds, Long targetUserId);

    R processAttempt(TestAttempt testAttempt);
}
