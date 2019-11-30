package loc.aliar.monitoringsystemserver.controller.admin;

import loc.aliar.monitoringsystemserver.model.admin.IdAble;
import loc.aliar.monitoringsystemserver.service.admin.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class CrudController<E, M extends IdAble> {
    private static final String TO_RESOURCE = "/{id}";

    protected ResponseEntity<?> read() {
        List<M> all = getCrudService().getAll();
        return ResponseEntity.ok(all);
    }

    protected ResponseEntity<?> read(Long id) {
        M one = getCrudService().get(id);
        return ResponseEntity.ok(one);
    }

    protected ResponseEntity<?> create(M entityModel) {
        M created = getCrudService().save(entityModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(TO_RESOURCE)
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    protected ResponseEntity<?> update(Long id, M entityModel) {
        M updated = getCrudService().save(id, entityModel);
        return ResponseEntity.ok(updated);
    }

    protected ResponseEntity<?> delete(Long id) {
        getCrudService().delete(id);
        return ResponseEntity.noContent().build();
    }

    protected abstract CrudService<E, M> getCrudService();
}
