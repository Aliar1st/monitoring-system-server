package loc.aliar.monitoringsystemserver.model.test.result.impl;

import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MaxScoreTestResult implements TestResult {
    private Integer maxScore;
}
