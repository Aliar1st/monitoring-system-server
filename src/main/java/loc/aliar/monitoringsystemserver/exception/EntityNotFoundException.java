package loc.aliar.monitoringsystemserver.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException {
    private static final String MSG = "%s with id %s not found";

    public EntityNotFoundException(String name, Number id) {
        this(name, id.toString());
    }

    public EntityNotFoundException(String name, String id) {
        super(String.format(MSG, name, id));
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public static Supplier<EntityNotFoundException> of(Class<?> entityClass, Number id) {
        return () -> new EntityNotFoundException(entityClass.getSimpleName(), id);
    }

    public static Supplier<EntityNotFoundException> of(Class<?> entityClass, String id) {
        return () -> new EntityNotFoundException(entityClass.getSimpleName(), id);
    }
}
