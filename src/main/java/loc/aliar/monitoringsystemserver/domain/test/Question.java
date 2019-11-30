package loc.aliar.monitoringsystemserver.domain.test;

import loc.aliar.monitoringsystemserver.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.QUESTION_NAME_MAX;

@Getter
@Setter
@Entity
public class Question extends AbstractEntity {
    @Column(length = QUESTION_NAME_MAX, nullable = false)
    private String name;

    private Short ordinal;

    @Column(nullable = false)
    @ColumnDefault("1")
    private Short maxAnswers;

    @Column(nullable = false)
    @ColumnDefault("1")
    private Short minAnswers;
//    private Boolean required;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Test test;

    @OrderBy("ordinal")
    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;
}
