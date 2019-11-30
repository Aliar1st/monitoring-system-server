package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Admin;
import loc.aliar.monitoringsystemserver.model.admin.AdminModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminModelToAdminConverter implements Converter<AdminModel, Admin> {
    @Override
    public Admin convert(AdminModel adminModel) {
        return Admin.builder()
                .build();
    }
}
