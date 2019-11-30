package loc.aliar.monitoringsystemserver.exception;

public class UserNotAuthenticatedException extends RuntimeException {
    private static final String MSG = "User is not authenticated";

    public UserNotAuthenticatedException() {
        super(MSG);
    }
}

