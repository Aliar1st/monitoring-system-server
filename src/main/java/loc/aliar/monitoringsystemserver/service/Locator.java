package loc.aliar.monitoringsystemserver.service;

public interface Locator<B, T extends Enum<?>> {
    B byType(T type);
}
