package loc.aliar.monitoringsystemserver.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
@ConfigurationProperties("security")
public class SecurityProperties {
    private JwtProperties jwt;

    @Getter @Setter
    public static class JwtProperties {
        private String secret;
        private Long expiration;
    }
}
