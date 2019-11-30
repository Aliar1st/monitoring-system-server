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
@JsonDeserialize(using = SpecialistType.SpecialistTypeDeserializer.class)
public enum SpecialistType {
    POLYCLINIC(TestType.DETERMINATION_COMPLETENESS_CLINIC),
    HOSPITAL(TestType.DETERMINATION_COMPLETENESS_HOSPITAL),
    ;

    private final TestType test;

    public static class SpecialistTypeDeserializer extends EnumDeserializer<SpecialistType> {
        @Override
        public Class<SpecialistType> getEnumClass() {
            return SpecialistType.class;
        }
    }
}
