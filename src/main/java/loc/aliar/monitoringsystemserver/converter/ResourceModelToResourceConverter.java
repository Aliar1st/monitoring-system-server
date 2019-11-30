package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Resource;
import loc.aliar.monitoringsystemserver.model.admin.ResourceModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResourceModelToResourceConverter implements Converter<ResourceModel, Resource> {
    @Override
    public Resource convert(ResourceModel source) {
        return Resource.builder()
                .build();
    }
}
