package loc.aliar.monitoringsystemserver.domain.test;

import loc.aliar.monitoringsystemserver.domain.AbstractEntity;
import loc.aliar.monitoringsystemserver.domain.Department;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.TEST_NAME_MAX;

@Getter
@Setter
@Entity
@NamedEntityGraph(
        name = Test.EG_TQA,
        attributeNodes =
        @NamedAttributeNode(value = "questions", subgraph = Test.EG_QA),
        subgraphs = @NamedSubgraph(
                name = Test.EG_QA,
                attributeNodes = @NamedAttributeNode("answers")))
public class Test extends AbstractEntity {
    public final static String EG_TQA = "Test:test_t.questions_q.answers";
    final static String EG_QA = "Test:questions_q.answers";

    @Column(length = TEST_NAME_MAX, nullable = false)
    private String name;

    @Enumerated
    @Column(nullable = false)
    private TestProcessType testProcessType;

    @Enumerated
    @Column(nullable = false)
    private Department department;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean visible;

    @OrderBy("ordinal")
    @OneToMany(mappedBy = "test")
    private Set<Question> questions;
}
