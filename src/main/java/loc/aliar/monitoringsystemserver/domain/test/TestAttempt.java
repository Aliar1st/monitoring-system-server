package loc.aliar.monitoringsystemserver.domain.test;

import loc.aliar.monitoringsystemserver.domain.AbstractAuditEntity;
import loc.aliar.monitoringsystemserver.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = TestAttempt.EG_ALL,
                attributeNodes = {
                        @NamedAttributeNode(TestAttempt_.ANSWERS),
                        @NamedAttributeNode(value = TestAttempt_.TEST, subgraph = Test.EG_TQA)
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = Test.EG_TQA,
                                attributeNodes = @NamedAttributeNode(value = Test_.QUESTIONS, subgraph = Test.EG_QA)),
                        @NamedSubgraph(
                                name = Test.EG_QA,
                                attributeNodes = @NamedAttributeNode(Question_.ANSWERS))
                }
        ),
        @NamedEntityGraph(
                name = TestAttempt.EG_TEST,
                attributeNodes = {
                        @NamedAttributeNode(TestAttempt_.TEST),
                        @NamedAttributeNode(TestAttempt_.ANSWERS)}
        )
})
public class TestAttempt extends AbstractAuditEntity {
    public final static String EG_ALL = "TestAttempt:all";
    public final static String EG_TEST = "TestAttempt:test";

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User passedUser;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User targetUser;

    @ManyToOne(optional = false)
    private Test test;

    @ManyToMany
    private Set<Answer> answers;
}
