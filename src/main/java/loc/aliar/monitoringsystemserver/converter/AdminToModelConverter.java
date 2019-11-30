package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Admin;
import loc.aliar.monitoringsystemserver.model.admin.AdminModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminToModelConverter implements Converter<Admin, AdminModel> {
    @Override
    public AdminModel convert(Admin admin) {
        return AdminModel.builder()
                .id(admin.getId())
                .firstName(admin.getUser().getFirstName())
                .lastName(admin.getUser().getLastName())
                .middleName(admin.getUser().getMiddleName())
                .username(admin.getUser().getUsername())
                .department(admin.getUser().getDepartments().iterator().next())
                .build();
    }
}
