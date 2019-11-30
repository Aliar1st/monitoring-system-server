package loc.aliar.monitoringsystemserver.service.admin.base;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Patient;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.repository.PatientRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BasePatientService implements PatientService {
    private final PatientRepository repository;
    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final ConversionService conversionService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<PatientModel> getByDepartment(Department department) {
        List<Patient> patients = repository.getAllByUserDepartmentsContains(department);
        return convertToModelList(patients);
    }

    @Override
    public JpaRepository<Patient, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Class<PatientModel> getModelClass() {
        return PatientModel.class;
    }

    @Override
    public SecurityService getSecurityService() {
        return securityService;
    }

    @Override
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
