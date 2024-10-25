package ua.mibal.repository;

import ua.mibal.model.WithId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public abstract class InMemoryRepository<E extends WithId> {
    protected final List<E> entities = new ArrayList<>();
    private int idGenerator = 0;

    public Optional<E> findById(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    public Optional<E> deleteById(Long id) {
        Optional<E> optionalEntity = findById(id);
        optionalEntity.ifPresent(entities::remove);
        return optionalEntity;
    }

    public E save(E entity) {
        entity.setId((long) idGenerator++);
        entities.add(entity);
        return entity;
    }

    public List<E> findAll() {
        return unmodifiableList(entities);
    }
}
