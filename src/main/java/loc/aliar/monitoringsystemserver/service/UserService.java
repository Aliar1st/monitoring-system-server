package loc.aliar.monitoringsystemserver.service;

import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.UserModel;

import java.util.Optional;

public interface UserService {
    Optional<User> get(Long id);

    UserModel get(String username, String password);
}
