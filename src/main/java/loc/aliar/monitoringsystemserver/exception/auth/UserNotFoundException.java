package loc.aliar.monitoringsystemserver.exception.auth;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException {
    private static final String MSG_ID = "User with id %d not found";
    private static final String MSG_USERNAME = "User with username %s not found";

    public UserNotFoundException(Long userId) {
        super(String.format(MSG_ID, userId));
    }

    public UserNotFoundException(String username) {
        super(String.format(MSG_USERNAME, username));
    }
}
