package loc.aliar.monitoringsystemserver.config.auth;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.domain.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private final User user;
    private String token;

    public JwtAuthenticationToken(String token) {
        super(null);
        this.user = null;
        this.token = token;
        super.setAuthenticated(false);
    }

    public JwtAuthenticationToken(User user, String token, Role role) {
        super(Collections.singleton(role));
        this.user = user;
        this.token = token;
        super.setAuthenticated(true);
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public User getPrincipal() {
        return user;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        token = null;
    }
}
