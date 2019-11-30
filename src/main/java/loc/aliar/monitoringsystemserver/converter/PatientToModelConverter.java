package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Patient;
import loc.aliar.monitoringsystemserver.model.admin.PatientModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientToModelConverter implements Converter<Patient, PatientModel> {
    @Override
    public PatientModel convert(Patient patient) {
        return PatientModel.builder()
                .id(patient.getId())
                .firstName(patient.getUser().getFirstName())
                .lastName(patient.getUser().getLastName())
                .middleName(patient.getUser().getMiddleName())
                .username(patient.getUser().getUsername())
                .department(patient.getUser().getDepartments().iterator().next())
                .dateOfBirth(patient.getDateOfBirth())
                .doctorId(patient.getDoctor().getId())
                .build();
    }
}
