package loc.aliar.monitoringsystemserver.config.auth;

import loc.aliar.monitoringsystemserver.service.JwtService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static loc.aliar.monitoringsystemserver.service.JwtService.TOKEN_HEADER;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authException
    ) throws IOException {
        String authHeader = request.getHeader(TOKEN_HEADER);
        if (ObjectUtils.isEmpty(authHeader)) {
            sendUnauthorized(response);
        } else {
            sendForbidden(response);
        }
    }

    private void sendForbidden(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }

    private void sendUnauthorized(HttpServletResponse response) throws IOException {
        response.addHeader("WWW-Authenticate", JwtService.TOKEN_TYPE);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}