package loc.aliar.monitoringsystemserver.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static loc.aliar.monitoringsystemserver.service.JwtService.TOKEN_HEADER;
import static loc.aliar.monitoringsystemserver.service.JwtService.TOKEN_TYPE;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            Authentication authentication = attemptAuthentication(request);
            successfulAuthentication(request, response, filterChain, authentication);
        } catch (AuthenticationException failed) {
            unsuccessfulAuthentication(request, response, filterChain, failed);
        }
    }

    private Authentication attemptAuthentication(HttpServletRequest request) throws AuthenticationException {
        String token = obtainJwt(request);

        JwtAuthenticationToken authenticationRequest = new JwtAuthenticationToken(token);
        authenticationRequest.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        return authenticationManager.authenticate(authenticationRequest);
    }

    private String obtainJwt(HttpServletRequest request) {
        String authHeader = request.getHeader(TOKEN_HEADER);
        if (StringUtils.hasText(authHeader) && authHeader.startsWith(TOKEN_TYPE)) {
            return authHeader.substring(TOKEN_TYPE.length());
        }
        return null;
    }

    private void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult
    ) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);

        if (logger.isDebugEnabled()) {
            logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
        }

        chain.doFilter(request, response);
    }

    private void unsuccessfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain, AuthenticationException failed
    ) throws IOException, ServletException {
        SecurityContextHolder.clearContext();

        if (logger.isDebugEnabled()) {
            logger.debug("Authentication request failed: " + failed.toString(), failed);
            logger.debug("Updated SecurityContextHolder to contain null Authentication");
            logger.debug("Delegating to next filter");
        }

        chain.doFilter(request, response);
    }
}
