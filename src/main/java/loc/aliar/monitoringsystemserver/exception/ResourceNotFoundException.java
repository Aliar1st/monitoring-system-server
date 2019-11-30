package loc.aliar.monitoringsystemserver.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final String MSG = "Resource with id %d not found";

    public ResourceNotFoundException(Long id, Throwable cause) {
        super(String.format(MSG, id), cause);
    }
}
