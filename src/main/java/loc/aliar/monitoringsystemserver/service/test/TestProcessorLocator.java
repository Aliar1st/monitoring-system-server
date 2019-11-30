package loc.aliar.monitoringsystemserver.service.test;

import loc.aliar.monitoringsystemserver.domain.test.TestProcessType;
import loc.aliar.monitoringsystemserver.exception.TestTypeUnsupportedException;
import loc.aliar.monitoringsystemserver.model.test.TargetTestType;
import loc.aliar.monitoringsystemserver.service.BaseLocator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Supplier;

@Component
public class TestProcessorLocator extends BaseLocator<TestProcessor<?>, TargetTestType, TestProcessType> {
    public TestProcessorLocator(List<TestProcessor<?>> beans) {
        super(beans);
    }

    @PostConstruct
    protected void init() {
        super.init();
    }

    @Override
    protected Class<TargetTestType> getAnnotationClass() {
        return TargetTestType.class;
    }

    @Override
    protected Supplier<? extends RuntimeException> getThrowable() {
        return TestTypeUnsupportedException::new;
    }

    @Override
    protected TestProcessType getAnnotationValue(TestProcessor<?> processor) {
        return getAnnotation(processor).value();
    }
}
