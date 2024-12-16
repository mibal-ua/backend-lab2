package ua.mibal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.model.User;
import ua.mibal.service.UserService;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService service;

    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return service.getAll();
    }
}
