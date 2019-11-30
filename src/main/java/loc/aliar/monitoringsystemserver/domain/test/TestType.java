package loc.aliar.monitoringsystemserver.domain.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.util.EnumDeserializer;
import loc.aliar.monitoringsystemserver.util.EnumSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonSerialize(using = EnumSerializer.class)
@JsonDeserialize(using = TestType.TestTypeDeserializer.class)
public enum TestType {
    KNEE_ENDOPROSTHESIS(1L),

    // For big form
    INDICATIONS_CNS(2L),
    INDICATIONS_MSS(3L),
    INDICATIONS_PNS(4L),
    DETERMINATION_CONTRAINDICATIONS(5L),
    DETERMINATION_COMPLETENESS_CLINIC(6L),
    DETERMINATION_COMPLETENESS_HOSPITAL(7L),
    ;

    @JsonIgnore
    private final Long id;

    public static TestType byType(String type) {
        try {
            return TestType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw EntityNotFoundException.of(Test.class, type).get();
        }
    }

    public static class TestTypeDeserializer extends EnumDeserializer<TestType> {
        @Override
        public Class<TestType> getEnumClass() {
            return TestType.class;
        }
    }
}
