package ua.mibal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.model.User;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RestController
public class UserController {

    @GetMapping("/user/{userId}")
    public User get(@PathVariable Long userId) {
        return null;
    }

    @DeleteMapping("/user/{userId}")
    public User delete(@PathVariable Long userId) {
        return null;
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return null;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return null;
    }
}
