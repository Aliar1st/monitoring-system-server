package loc.aliar.monitoringsystemserver.util;

import org.apache.commons.logging.Log;

public abstract class LogUtils {
    private LogUtils() {
    }

    public static void debug(Log log, String message, Object... args) {
        if (log.isDebugEnabled()) {
            log.debug(String.format(message, args));
        }
    }

    public static void error(Log log, Throwable exception, String message, Object... args) {
        if (log.isErrorEnabled()) {
            log.error(String.format(message, args), exception);
        }
    }
}
