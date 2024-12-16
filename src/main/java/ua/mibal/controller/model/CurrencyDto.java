package ua.mibal.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Builder
public record CurrencyDto(
        @NotBlank
        String name
) {
}
