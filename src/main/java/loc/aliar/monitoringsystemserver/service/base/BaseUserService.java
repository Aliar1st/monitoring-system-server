package loc.aliar.monitoringsystemserver.service.base;

import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.exception.auth.InvalidCredentialsException;
import loc.aliar.monitoringsystemserver.exception.auth.UserNotFoundException;
import loc.aliar.monitoringsystemserver.model.UserModel;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BaseUserService implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    @Override
    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserModel get(String username, String password) {
        Optional<User> userOpt = repository.getByUsername(username);
        if (!userOpt.isPresent()) {
            throw new UserNotFoundException(username);
        }
        User user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException();
        }
        return conversionService.convert(user, UserModel.class);
    }

    // TODO: 12/1/2019 REMOVE
//    @PostConstruct
//    public void test() {
//        get("sadmin", null);
//    }
}
