package loc.aliar.monitoringsystemserver.exception.auth;

import org.springframework.security.core.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {
    public InvalidCredentialsException() {
        super("Credentials do not match");
    }
}
