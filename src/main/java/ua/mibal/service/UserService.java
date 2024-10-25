package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.exception.NotFoundException;
import ua.mibal.model.User;
import ua.mibal.repository.UserRepository;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User deleteById(Long id) {
        return repository.deleteById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
