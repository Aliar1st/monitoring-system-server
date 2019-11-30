package loc.aliar.monitoringsystemserver.domain;

import loc.aliar.monitoringsystemserver.exception.EntityNotFoundException;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum Department {
    GLOBAL,
    KNEE_ENDOPROSTHESIS,
    CARDIOLOGY,
    INSULT,
    ;

    private static final Set<Department> EXCLUDE_GLOBAL;

    static {
        EnumSet<Department> all = EnumSet.allOf(Department.class);
        all.remove(GLOBAL);

        EXCLUDE_GLOBAL = Collections.unmodifiableSet(all);
    }

    public static Set<Department> resolve(Set<Department> departments) {
        if (departments.contains(GLOBAL)) {
            return EXCLUDE_GLOBAL;
        }
        return departments;
    }

    public static Department byType(String type) {
        try {
            return Department.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw EntityNotFoundException.of(Department.class, type).get();
        }
    }
}
