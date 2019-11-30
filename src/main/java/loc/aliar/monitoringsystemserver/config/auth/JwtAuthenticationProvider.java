package loc.aliar.monitoringsystemserver.config.auth;

import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.exception.auth.InvalidJwtException;
import loc.aliar.monitoringsystemserver.exception.auth.UserNotFoundException;
import loc.aliar.monitoringsystemserver.service.UserService;
import loc.aliar.monitoringsystemserver.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtService jwtService;
    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(JwtAuthenticationToken.class, authentication,
                () -> "Only JwtAuthenticationToken is supported");

        JwtAuthenticationToken jwtAuth = ((JwtAuthenticationToken) authentication);
        String token = jwtAuth.getCredentials();

        if (!StringUtils.hasText(token)) {
            throw new InvalidJwtException("Empty token");
        }

        jwtService.validateToken(token);

        Long userId = jwtService.getUserIdFromToken(token);

        User user = userService.get(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));


        JwtAuthenticationToken jwtAuthenticated = new JwtAuthenticationToken(user, token, user.getRole());
        jwtAuthenticated.setDetails(jwtAuth.getDetails());

        return jwtAuthenticated;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.equals(authentication);
    }
}
