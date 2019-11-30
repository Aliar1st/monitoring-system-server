package loc.aliar.monitoringsystemserver.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SUPER_ADMIN, ADMIN, DOCTOR, PATIENT;

    public static final String DEFAULT_ROLE_PREFIX = "ROLE_";

    @Override
    public String getAuthority() {
        return DEFAULT_ROLE_PREFIX + name();
    }
}
