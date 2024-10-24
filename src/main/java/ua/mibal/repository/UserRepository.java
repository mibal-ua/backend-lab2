package ua.mibal.repository;

import ua.mibal.model.User;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface UserRepository {
    User findById(Long id);

    User deleteById(Long id);

    User save(User user);

    List<User> findAll();
}
