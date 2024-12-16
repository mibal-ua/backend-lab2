package ua.mibal.controller.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record RecordDto(
        @NotNull
        Long userId,
        @NotNull
        Long categoryId,
        @NotNull
        @Positive
        Long amount,
        Long currencyId
) {
}
