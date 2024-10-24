package ua.mibal.repository;

import org.springframework.stereotype.Repository;
import ua.mibal.model.Category;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Repository
public class CategoryRepository extends InMemoryRepository<Category> {
}
