package loc.aliar.monitoringsystemserver.service.admin.base;

import loc.aliar.monitoringsystemserver.domain.Admin;
import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.model.admin.AdminModel;
import loc.aliar.monitoringsystemserver.repository.AdminRepository;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.service.admin.AdminService;
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
public class BaseAdminService implements AdminService {
    private final AdminRepository repository;
    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final ConversionService conversionService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<AdminModel> getByDepartment(Department department) {
        List<Admin> admins = repository.getAllByUserDepartmentsContains(department);
        return convertToModelList(admins);
    }

    @Override
    public JpaRepository<Admin, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public Class<AdminModel> getModelClass() {
        return AdminModel.class;
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

//    @PostConstruct
//    void test() {
//        AdminModel a = AdminModel.builder()
//                .username("Hello123")
//                .department(Department.KNEE_ENDOPROSTHESIS)
//                .build();
//        save(4L, a);
//    }
}
