package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.BaseEntity;
import learn.spring.petclinic.service.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {

        if (Objects.nonNull(object)) {
            if (Objects.isNull(object.getId())) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);

        } else {
            throw new RuntimeException("Object cannot be null!");
        }

        return object;
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        return map.keySet().isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
