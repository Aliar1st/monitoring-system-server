package loc.aliar.monitoringsystemserver.controller;

import loc.aliar.monitoringsystemserver.model.UserModel;
import loc.aliar.monitoringsystemserver.model.request.AuthLoginRequest;
import loc.aliar.monitoringsystemserver.model.response.AuthLoginResponse;
import loc.aliar.monitoringsystemserver.service.JwtService;
import loc.aliar.monitoringsystemserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request) {
        UserModel user = userService.get(request.getUsername(), request.getPassword());
        String token = jwtService.generateToken(user.getId());
        AuthLoginResponse response = AuthLoginResponse.builder()
                .token(token)
                .user(user)
                .build();
        return ResponseEntity.ok(response);
    }
}
