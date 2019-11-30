package loc.aliar.monitoringsystemserver.service.admin.base;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Doctor;
import loc.aliar.monitoringsystemserver.domain.Patient;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.model.admin.DoctorModel;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.repository.DoctorRepository;
import loc.aliar.monitoringsystemserver.repository.PatientRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.DoctorService;
import loc.aliar.monitoringsystemserver.util.AssertUtils;
import loc.aliar.monitoringsystemserver.util.ConverterUtils;
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
public class BaseDoctorService implements DoctorService {
    private final DoctorRepository repository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final ConversionService conversionService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<DoctorModel> getByDepartment(Department department) {
        List<Doctor> doctors = repository.getAllByUserDepartmentsContains(department);
        return convertToModelList(doctors);
    }

    @Override
    public List<PatientModel> getDoctorsPatients() {
        Long id = securityService.getCurrentUser().getId();
        List<Patient> doctorsPatients = patientRepository.getAllByDoctorId(id);
        return ConverterUtils.convertList(doctorsPatients, PatientModel.class, conversionService);
    }

    @Override
    public boolean isDoctorsPatient(Long patientId) {
        if (!AssertUtils.isIdValid(patientId)) {
            throw EntityNotFoundException.of(Patient.class, patientId).get();
        }

        Long currentId = securityService.getCurrentUser().getId();
        List<Patient> doctorsPatients = patientRepository.getAllByDoctorId(currentId);
        return doctorsPatients.stream()
                .anyMatch(patient -> patientId.equals(patient.getId()));
    }

    @Override
    public JpaRepository<Doctor, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    public Class<DoctorModel> getModelClass() {
        return DoctorModel.class;
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
