package ua.mibal.controller.model;

import jakarta.validation.constraints.NotBlank;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record CategoryDto(
        @NotBlank
        String name
) {
}
