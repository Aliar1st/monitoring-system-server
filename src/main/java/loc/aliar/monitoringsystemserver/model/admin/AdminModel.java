package loc.aliar.monitoringsystemserver.model.admin;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.validation.annotation.HasAccessToDepartment;
import loc.aliar.monitoringsystemserver.validation.annotation.Unique;
import loc.aliar.monitoringsystemserver.validation.annotation.UniqueExceptCurrent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.*;

@Getter
@Setter
@Builder
@UniqueExceptCurrent(value = UserRepository.class,
        uniqueFieldName = "username",
        errorFieldName = "username",
        groups = Validation.Update.class)
public class AdminModel implements IdAble {
    @NotNull(groups = Validation.Update.class)
    @Positive(groups = Validation.Update.class)
    private Long id;

    @NotEmpty
    @Size(min = USERNAME_MIN, max = USERNAME_MAX)
    @Unique(value = UserRepository.class, fieldName = "username", groups = Validation.Create.class)
    private String username;

    @NotEmpty(groups = Validation.Create.class)
    @Size(min = PASSWORD_MIN, max = PASSWORD_MAX)
    private String password;

    @Size(min = FIRST_NAME_MIN, max = FIRST_NAME_MAX)
    private String firstName;

    @Size(min = LAST_NAME_MIN, max = LAST_NAME_MAX)
    private String lastName;

    @Size(min = MIDDLE_NAME_MIN, max = MIDDLE_NAME_MAX)
    private String middleName;

//    @Pattern(regexp = PHONE_PATTERN)
//    @Size(min = PHONE_MIN, max = PHONE_MAX)
//    private String phone;

//    @Email
//    @Size(min = EMAIL_MIN, max = EMAIL_MAX)
//    private String email;

    @HasAccessToDepartment
    private Department department;
}
