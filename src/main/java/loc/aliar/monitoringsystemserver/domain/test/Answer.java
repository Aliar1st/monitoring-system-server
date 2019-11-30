package loc.aliar.monitoringsystemserver.domain.test;

import loc.aliar.monitoringsystemserver.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.ANSWER_DATA_MAX;
import static loc.aliar.monitoringsystemserver.domain.FieldParameters.ANSWER_NAME_MAX;

@Getter
@Setter
@Entity
public class Answer extends AbstractEntity {
    @Column(length = ANSWER_NAME_MAX, nullable = false)
    private String name;

    private Short ordinal;

    @Column(length = ANSWER_DATA_MAX)
    private String data;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;
}
