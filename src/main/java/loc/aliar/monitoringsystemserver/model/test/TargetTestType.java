package loc.aliar.monitoringsystemserver.model.test;

import loc.aliar.monitoringsystemserver.domain.test.TestProcessType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TargetTestType {
    TestProcessType value();
}
