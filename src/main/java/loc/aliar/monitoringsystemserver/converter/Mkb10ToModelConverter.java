package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Mkb10;
import loc.aliar.monitoringsystemserver.model.Mkb10Model;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Mkb10ToModelConverter implements Converter<Mkb10, Mkb10Model> {
    @Override
    public Mkb10Model convert(Mkb10 mkb10) {
        return Mkb10Model.builder()
                .id(mkb10.getId())
                .code(mkb10.getCode())
                .name(mkb10.getName())
                .build();
    }
}
