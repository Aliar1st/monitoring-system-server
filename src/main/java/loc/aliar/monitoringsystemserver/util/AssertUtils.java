package loc.aliar.monitoringsystemserver.util;

public abstract class AssertUtils {
    private AssertUtils() {
    }

    public static void checkIdValid(Number id) {
        if (!isIdValid(id)) {
            throw new IllegalArgumentException(
                    String.format("Id %d is illegal, must be greater than 0", id.longValue()));
        }
    }

    public static boolean isIdValid(Number id) {
        return id != null && id.longValue() > 0;
    }
}
