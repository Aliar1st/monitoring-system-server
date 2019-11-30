package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Doctor;
import loc.aliar.monitoringsystemserver.model.admin.DoctorModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoctorToModelConverter implements Converter<Doctor, DoctorModel> {
    @Override
    public DoctorModel convert(Doctor doctor) {
        return DoctorModel.builder()
                .id(doctor.getId())
                .firstName(doctor.getUser().getFirstName())
                .lastName(doctor.getUser().getLastName())
                .middleName(doctor.getUser().getMiddleName())
                .username(doctor.getUser().getUsername())
                .department(doctor.getUser().getDepartments().iterator().next())
                .medicalInstitution(doctor.getMedicalInstitution())
                .build();
    }
}
