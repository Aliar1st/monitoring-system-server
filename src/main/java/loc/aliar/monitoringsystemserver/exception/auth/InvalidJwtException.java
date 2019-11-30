package loc.aliar.monitoringsystemserver.exception.auth;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtException extends AuthenticationException {
    public InvalidJwtException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidJwtException(String msg) {
        super(msg);
    }
}
