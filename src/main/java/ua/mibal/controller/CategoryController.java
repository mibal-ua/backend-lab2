package ua.mibal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.model.Category;
import ua.mibal.service.CategoryService;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService service;

    //todo
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
        return service.create(category);
    }
}
