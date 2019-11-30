package loc.aliar.monitoringsystemserver.model.test.result.impl;

import loc.aliar.monitoringsystemserver.model.ProgramModel;
import loc.aliar.monitoringsystemserver.model.test.result.TestResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class KneeEndoprosthesisTestResult implements TestResult {
    private List<String> recommendations;
    private List<ProgramModel> programs;
}
