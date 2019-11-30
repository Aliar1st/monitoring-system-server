package loc.aliar.monitoringsystemserver.model.form.form.impl.decisionsupport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import loc.aliar.monitoringsystemserver.domain.test.TestType;
import loc.aliar.monitoringsystemserver.util.EnumDeserializer;
import loc.aliar.monitoringsystemserver.util.EnumSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonSerialize(using = EnumSerializer.class)
@JsonDeserialize(using = PatientProfileType.PatientProfileTypeDeserializer.class)
public enum PatientProfileType {
    CENTRAL_NERVOUS_SYSTEM(TestType.INDICATIONS_CNS),
    PERIPHERAL_NERVOUS_SYSTEM(TestType.INDICATIONS_PNS),
    MUSCULOSKELETAL_SYSTEM(TestType.INDICATIONS_MSS),
    ;

    private final TestType test;

    public static class PatientProfileTypeDeserializer extends EnumDeserializer<PatientProfileType> {
        @Override
        public Class<PatientProfileType> getEnumClass() {
            return PatientProfileType.class;
        }
    }
}
