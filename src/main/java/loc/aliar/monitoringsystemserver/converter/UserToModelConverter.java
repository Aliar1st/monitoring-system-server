package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToModelConverter implements Converter<User, UserModel> {
    @Override
    public UserModel convert(User user) {
        return UserModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .departments(user.getDepartments())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .middleName(user.getMiddleName())
                .build();
    }
}
