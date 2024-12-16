package ua.mibal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mibal.model.User;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
