package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.service.SecurityService;
import loc.aliar.monitoringsystemserver.validation.annotation.NotNullIfAnyOfRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotNullIfAnyOfRoleValidatorTest {

    @InjectMocks
    private NotNullIfAnyOfRoleValidator validator;

    @Mock
    private SecurityService securityService;

    private User currentUser;
    private NotNullIfAnyOfRole constraint;

    private Object nullObject = null;
    private Object notNullObject = new Object();

    @BeforeEach
    void init() {
        initCurrentUser();
        initConstraint();

        validator.initialize(constraint);
        when(securityService.getCurrentUser()).thenReturn(currentUser);
    }

    @Test
    void whenValueIsNullAndRoleMatch_thenInvalid() {
        boolean result = validator.isValid(nullObject, null);

        assertFalse(result);
    }

    @Test
    void whenValueIsNullAndRoleNotMatch_thenValid() {
        currentUser.setRole(Role.ADMIN);

        boolean result = validator.isValid(nullObject, null);

        assertTrue(result);
    }

    @Test
    void whenValueIsNotNullAndRoleMatch_thenValid() {
        boolean result = validator.isValid(notNullObject, null);

        assertTrue(result);
    }

    @Test
    void whenValueIsNotNullAndRoleNotMatch_thenValid() {
        currentUser.setRole(Role.ADMIN);

        boolean result = validator.isValid(notNullObject, null);

        assertTrue(result);
    }

    private void initCurrentUser() {
        currentUser = User.builder()
                .role(Role.SUPER_ADMIN)
                .build();
    }

    private void initConstraint() {
        constraint = new NotNullIfAnyOfRole() {
            public Role[] value() {
                return new Role[] {Role.SUPER_ADMIN};
            }
            public Class<? extends Annotation> annotationType() {
                return null;
            }
            public String message() {
                return null;
            }
            public Class<?>[] groups() {
                return new Class[0];
            }
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }
        };
    }
}