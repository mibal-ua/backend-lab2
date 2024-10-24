package ua.mibal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.model.Category;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping
    public Category get() {
        return null;
    }

    @DeleteMapping
    public Category delete() {
        return null;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return null;
    }
}
