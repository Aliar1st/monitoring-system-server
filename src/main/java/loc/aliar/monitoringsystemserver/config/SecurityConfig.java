package loc.aliar.monitoringsystemserver.config;

import loc.aliar.monitoringsystemserver.config.auth.JwtAuthenticationFilter;
import loc.aliar.monitoringsystemserver.config.auth.RestAuthenticationEntryPoint;
import loc.aliar.monitoringsystemserver.domain.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf().disable()
                .logout().disable()
                .cors().and()
                .exceptionHandling()
                    .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                    .antMatchers("/**").permitAll()
                    .antMatchers("/api/auth/**").permitAll()
                    .antMatchers("/api/doctors/**").hasRole(Role.DOCTOR.name())
                    .antMatchers("/api/patient/**").hasRole(Role.PATIENT.name())
                    .antMatchers("/api/admin/**").hasAnyRole(Role.ADMIN.name(), Role.SUPER_ADMIN.name())
                    .anyRequest().authenticated()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(
                        new JwtAuthenticationFilter(authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class);
        // @formatter:on
    }
}
