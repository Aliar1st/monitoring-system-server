package loc.aliar.monitoringsystemserver.service.admin.base;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Resource;
import loc.aliar.monitoringsystemserver.exception.ResourceNotFoundException;
import loc.aliar.monitoringsystemserver.model.admin.ResourceModel;
import loc.aliar.monitoringsystemserver.repository.ResourceRepository;
import loc.aliar.monitoringsystemserver.service.admin.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.UrlResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BaseResourceService implements ResourceService {
    private final ResourceRepository repository;
    private final ConversionService conversionService;

    @Value("${file_storage}")
    private String storageUri;

    @Override
    public List<ResourceModel> getByDepartment(Department department) {
        List<Resource> resources = repository.getAllByDepartmentAndVisibleTrue(department);
        return convertToModelList(resources);
    }

    @Override
    public ResourceModel getResource(Long id) {
        Resource resource = repository.findById(id).orElseThrow(getEntityNotFoundExceptionSupplier(id));
        ResourceModel resourceModel = convertToModel(resource);
        Path path = Paths.get(storageUri + resource.getPath());
        try {
            resourceModel.setResource(new UrlResource(path.toUri()));
            return resourceModel;
        } catch (MalformedURLException e) {
            throw new ResourceNotFoundException(id, e);
        }
    }

    @Override
    public JpaRepository<Resource, Long> getRepository() {
        return repository;
    }

    @Override
    public ConversionService getConversationService() {
        return conversionService;
    }

    @Override
    public Class<Resource> getEntityClass() {
        return Resource.class;
    }

    @Override
    public Class<ResourceModel> getModelClass() {
        return ResourceModel.class;
    }
}
