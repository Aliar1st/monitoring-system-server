package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Doctor;
import loc.aliar.monitoringsystemserver.model.admin.DoctorModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoctorModelToDoctorConverter implements Converter<DoctorModel, Doctor> {
    @Override
    public Doctor convert(DoctorModel doctorModel) {
        return Doctor.builder()
                .medicalInstitution(doctorModel.getMedicalInstitution())
                .build();
    }
}
