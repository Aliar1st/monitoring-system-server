package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.admin.AdminModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdminModelToUserConverter implements Converter<AdminModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(AdminModel adminModel) {
        return User.builder()
                .firstName(adminModel.getFirstName())
                .lastName(adminModel.getLastName())
                .middleName(adminModel.getMiddleName())
                .role(Role.ADMIN)
                .username(adminModel.getUsername())
                .password(Optional.ofNullable(adminModel.getPassword())
                        .map(passwordEncoder::encode)
                        .orElse(null))
                .departments(Collections.singleton(adminModel.getDepartment()))
                .build();
    }
}
