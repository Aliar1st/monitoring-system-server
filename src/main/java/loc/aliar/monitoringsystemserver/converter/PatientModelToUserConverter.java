package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PatientModelToUserConverter implements Converter<PatientModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(PatientModel patientModel) {
        return User.builder()
                .firstName(patientModel.getFirstName())
                .lastName(patientModel.getLastName())
                .middleName(patientModel.getMiddleName())
                .role(Role.PATIENT)
                .username(patientModel.getUsername())
                .password(Optional.ofNullable(patientModel.getPassword())
                        .map(passwordEncoder::encode)
                        .orElse(null))
                .departments(Collections.singleton(patientModel.getDepartment()))
                .build();
    }
}
