package loc.aliar.monitoringsystemserver.model.request;

import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.validation.annotation.Exists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static loc.aliar.monitoringsystemserver.domain.FieldParameters.PASSWORD_MAX;
import static loc.aliar.monitoringsystemserver.domain.FieldParameters.PASSWORD_MIN;

@Getter
@Setter
@Builder
public class ChangePasswordRequest {
    @Exists(UserRepository.class)
    private Long userId;

    @NotEmpty
    @Size(min = PASSWORD_MIN, max = PASSWORD_MAX)
    private String newPassword;
}
