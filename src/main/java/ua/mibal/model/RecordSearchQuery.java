package ua.mibal.model;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record RecordSearchQuery(
        @RequestParam(name = "user_id", required = false) Long userId,
        @RequestParam(name = "category_id", required = false) Long categoryId
) {
}
