package loc.aliar.monitoringsystemserver.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthLoginRequest {
    private String username;
    private String password;
}
