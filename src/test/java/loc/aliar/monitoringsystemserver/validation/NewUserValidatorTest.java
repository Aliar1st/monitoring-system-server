package loc.aliar.monitoringsystemserver.validation;

import loc.aliar.monitoringsystemserver.validation.annotation.NewUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class NewUserValidatorTest {

    private static final Long ID = 1L;
    private static final String PASSWORD = "PASSWORD";

    private NewUserValidator validator = new NewUserValidator();

    private TestUser user;
    private NewUser constraint;

    @BeforeEach
    void init() {
        initUser();
        initConstraint();

        validator.initialize(constraint);
    }

    @Test
    void whenIdWithoutPassword_thenValid() {
        user.id = ID;
        user.password = null;

        boolean result = validator.isValid(user, null);

        assertTrue(result);
    }

    @Test
    void whenIdAndPassword_thenValid() {
        user.id = ID;
        user.password = PASSWORD;

        boolean result = validator.isValid(user, null);

        assertTrue(result);
    }

    @Test
    void whenPasswordWithoutId_thenValid() {
        user.id = null;
        user.password = PASSWORD;

        boolean result = validator.isValid(user, null);

        assertTrue(result);
    }

    @Test
    void whenWithoutIdAndPassword_thenInvalid() {
        user.id = null;
        user.password = null;

        boolean result = validator.isValid(user, null);

        assertFalse(result);
    }

    private void initUser() {
        user = new TestUser();
    }

    private void initConstraint() {
        constraint = new NewUser() {
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            public String idFieldName() {
                return "id";
            }

            public String passwordFieldName() {
                return "password";
            }

            public String uniqueFieldName() {
                return null;
            }

            public String fieldName() {
                return "field";
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

    private static class TestUser {
        private Long id;
        private String password;
    }
}