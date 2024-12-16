package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.controller.model.CategoryDto;
import ua.mibal.exception.NotFoundException;
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
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Category create(CategoryDto category) {
        return repository.save(
                Category.builder()
                        .name(category.name())
                        .build()
        );
    }
}
