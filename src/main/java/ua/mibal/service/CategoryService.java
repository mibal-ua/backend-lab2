package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.model.Category;
import ua.mibal.repository.CategoryRepository;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository repository;

    public Category getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    public Category deleteById(Long id) {
        return repository.deleteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    public Category create(Category category) {
        return repository.save(category);
    }
}
