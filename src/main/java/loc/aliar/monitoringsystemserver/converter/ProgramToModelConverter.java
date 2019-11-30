package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.test.program.Program;
import loc.aliar.monitoringsystemserver.model.ProgramModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProgramToModelConverter implements Converter<Program, ProgramModel> {
    @Override
    public ProgramModel convert(Program program) {
        return ProgramModel.builder()
                .name(program.getResource().getName())
                .resourceId(program.getResource().getId())
                .build();
    }
}
