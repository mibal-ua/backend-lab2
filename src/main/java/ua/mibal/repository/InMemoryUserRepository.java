package ua.mibal.repository;

import ua.mibal.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@org.springframework.stereotype.Repository
public class InMemoryUserRepository implements Repository<User, Long> {
    private final List<User> users = new ArrayList<>();
    private int idGenerator = 0;

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<User> deleteById(Long id) {
        Optional<User> optionalUser = findById(id);
        optionalUser.ifPresent(users::remove);
        return optionalUser;
    }

    @Override
    public User save(User user) {
        user.setId((long) idGenerator++);
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return unmodifiableList(users);
    }
}
