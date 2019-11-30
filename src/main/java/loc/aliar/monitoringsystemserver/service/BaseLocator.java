package loc.aliar.monitoringsystemserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.support.AopUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class BaseLocator<B, A extends Annotation, T extends Enum<?>> implements Locator<B, T> {
    protected final List<B> providers;

    private Map<T, B> providersMap;

    @Override
    public B byType(T type) {
        return Optional.ofNullable(providersMap.get(type))
                .orElseThrow(getThrowable());
    }

    protected void init() {
        providersMap = providers.stream()
                .filter(this::isAnnotationPresent)
                .collect(Collectors.toMap(this::getAnnotationValue, Function.identity()));
    }

    private boolean isAnnotationPresent(B provider) {
        return AopUtils.getTargetClass(provider).isAnnotationPresent(getAnnotationClass());
    }

    protected A getAnnotation(B provider) {
        return AopUtils.getTargetClass(provider).getAnnotation(getAnnotationClass());
    }

    protected abstract Class<A> getAnnotationClass();

    protected abstract Supplier<? extends RuntimeException> getThrowable();

    protected abstract T getAnnotationValue(B bean);
}
