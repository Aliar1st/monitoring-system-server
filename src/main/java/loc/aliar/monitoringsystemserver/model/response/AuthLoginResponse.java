package loc.aliar.monitoringsystemserver.model.response;

import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.model.UserModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthLoginResponse {
    private UserModel user;
    private String token;
}
