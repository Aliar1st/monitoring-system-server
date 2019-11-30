package loc.aliar.monitoringsystemserver.model.test.result.impl;

import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
public class RecommendationPerAnswerTestResult implements TestResult {
    private List<String> recommendations;
}
