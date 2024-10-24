package ua.mibal.repository;

import org.springframework.stereotype.Repository;
import ua.mibal.model.User;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Repository
public class UserRepository extends InMemoryRepository<User> {
}
