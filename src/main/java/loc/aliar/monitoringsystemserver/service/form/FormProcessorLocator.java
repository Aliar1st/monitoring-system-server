package loc.aliar.monitoringsystemserver.service.form;

import loc.aliar.monitoringsystemserver.exception.TestTypeUnsupportedException;
import loc.aliar.monitoringsystemserver.model.form.FormType;
import loc.aliar.monitoringsystemserver.model.form.TargetFormType;
import loc.aliar.monitoringsystemserver.service.BaseLocator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Supplier;

@Component
public class FormProcessorLocator extends BaseLocator<FormProcessor, TargetFormType, FormType> {
    public FormProcessorLocator(List<FormProcessor> beans) {
        super(beans);
    }

    @PostConstruct
    protected void init() {
        super.init();
    }

    @Override
    protected Class<TargetFormType> getAnnotationClass() {
        return TargetFormType.class;
    }

    @Override
    protected Supplier<? extends RuntimeException> getThrowable() {
        return TestTypeUnsupportedException::new;
    }

    @Override
    protected FormType getAnnotationValue(FormProcessor processor) {
        return getAnnotation(processor).value();
    }
}
