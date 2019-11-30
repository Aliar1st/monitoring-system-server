package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Patient;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import loc.aliar.monitoringsystemserver.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientModelToPatientConverter implements Converter<PatientModel, Patient> {
    private final DoctorRepository doctorRepository;

    @Override
    public Patient convert(PatientModel patientModel) {
        return Patient.builder()
                .doctor(doctorRepository.getOne(patientModel.getDoctorId()))
                .dateOfBirth(patientModel.getDateOfBirth())
                .build();
    }
}
