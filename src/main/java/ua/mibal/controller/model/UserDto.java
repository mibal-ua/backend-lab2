package ua.mibal.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record UserDto(
        @NotBlank
        String name,
        @NotNull
        Long defaultCurrencyId
) {
}
