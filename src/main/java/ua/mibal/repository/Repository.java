package ua.mibal.repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface Repository<T, ID> {

    Optional<T> findById(ID id);

    Optional<T> deleteById(ID id);

    T save(T entity);

    List<T> findAll();
}
