package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Resource;
import loc.aliar.monitoringsystemserver.model.admin.ResourceModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResourceToModelConverter implements Converter<Resource, ResourceModel> {
    @Override
    public ResourceModel convert(Resource resource) {
        return ResourceModel.builder()
                .id(resource.getId())
                .name(resource.getName())
                .department(resource.getDepartment())
                .build();
    }
}
