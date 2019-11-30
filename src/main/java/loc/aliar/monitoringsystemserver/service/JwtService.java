package loc.aliar.monitoringsystemserver.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import loc.aliar.monitoringsystemserver.config.properties.SecurityProperties;
import loc.aliar.monitoringsystemserver.exception.auth.InvalidJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "Bearer ";

    @Value("#{securityProperties.jwt}")
    private SecurityProperties.JwtProperties properties;
    private SecretKey key;

    @PostConstruct
    public void init() {
        String secret = properties.getSecret();
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(Long userId) {
        Date now = new Date();
        Long expiration = properties.getExpiration();
        Date expirationDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public void validateToken(String token) {
        Exception exception;
        String message;

        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token);
            return;
        } catch (SignatureException e) {
            exception = e;
            message = "Invalid JWT signature";
        } catch (MalformedJwtException e) {
            exception = e;
            message = "Malformed JWT token";
        } catch (ExpiredJwtException e) {
            exception = e;
            message = "Expired JWT token";
        } catch (UnsupportedJwtException e) {
            exception = e;
            message = "Unsupported JWT token";
        } catch (IllegalArgumentException e) {
            exception = e;
            message = "JWT claims string is empty";
        }

        throw new InvalidJwtException(message, exception);
    }
}
