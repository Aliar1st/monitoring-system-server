package loc.aliar.monitoringsystemserver.domain;

import loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport.PatientProfileType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.MKB_10_CODE_MAX;
import static loc.aliar.monitoringsystemserver.domain.FieldParameters.MKB_10_NAME_MAX;

@Getter
@Setter
@Entity
public class Mkb10 extends AbstractEntity {
    @NaturalId
    @Column(length = MKB_10_CODE_MAX, nullable = false)
    private String code;

    @Column(length = MKB_10_NAME_MAX, nullable = false)
    private String name;

    @Enumerated
    @ElementCollection
    @CollectionTable(
            uniqueConstraints = @UniqueConstraint(
                    name = "UX_mkb10Id_patientProfileTypes",
                    columnNames = {"mkb10_id", "patientProfileTypes"}),
            indexes = @Index(
                    name = "IX_patientProfileTypes",
                    columnList = "patientProfileTypes"))
    private Set<PatientProfileType> patientProfileTypes;
}