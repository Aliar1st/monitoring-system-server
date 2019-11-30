package loc.aliar.monitoringsystemserver.service.admin;

import loc.aliar.monitoringsystemserver.domain.SetUserAble;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface CrudUserService<E extends SetUserAble, M> extends CrudService<E, M> {
    @Override
    default M save(M model) {
//        Role currentRole = getSecurityService().getCurrentUser().getRole();
        User user = getConversationService().convert(model, User.class);
//        if (currentRole != Role.SUPER_ADMIN) {
//            user.setRole(currentRole);
//        }
        getUserRepository().save(user);

        E admin = convertToEntity(model);
        admin.setUser(user);
        getRepository().save(admin);

        return convertToModel(admin);
    }

    @Override
    default M save(Long id, M model) {
//        User currentUser = getSecurityService().getCurrentUser();
        User user = getUserRepository().findById(id).orElseThrow(EntityNotFoundException.of(User.class, id));
        User userToConvert = getConversationService().convert(model, User.class);
        BeanUtils.copyProperties(userToConvert, user, getIgnoreCopyProperties());
//        if (currentUser.getRole() != Role.SUPER_ADMIN) {
//            user.setDepartments(currentUser.getDepartments());
//        }

//        getUserRepository().save(user);

        E entity = getRepository().findById(id).orElseThrow(getEntityNotFoundExceptionSupplier(id));
        BeanUtils.copyProperties(convertToEntity(model), entity, getIgnoreCopyProperties());
        entity.setUser(user);
//        getRepository().save(admin);

        return convertToModel(entity);
    }

    default void changePassword(Long id, String newPassword) {
        String password = getPasswordEncoder().encode(newPassword);
        getUserRepository().updatePassword(id, password);
    }

    SecurityService getSecurityService();

    UserRepository getUserRepository();

    PasswordEncoder getPasswordEncoder();
}
