package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.admin.DoctorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DoctorModelToUserConverter implements Converter<DoctorModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(DoctorModel doctorModel) {
        return User.builder()
                .firstName(doctorModel.getFirstName())
                .lastName(doctorModel.getLastName())
                .middleName(doctorModel.getMiddleName())
                .role(Role.DOCTOR)
                .username(doctorModel.getUsername())
                .password(Optional.ofNullable(doctorModel.getPassword())
                        .map(passwordEncoder::encode)
                        .orElse(null))
                .departments(Collections.singleton(doctorModel.getDepartment()))
                .build();
    }
}
