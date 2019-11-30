package loc.aliar.monitoringsystemserver.repository.projection;

import java.util.List;

public interface TestSummary {
    String getName();

    List<QuestionSummary> getQuestions();
}
