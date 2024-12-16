package ua.mibal.controller.model;

import lombok.Builder;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */

@Builder
public record TokenDto(String token) {
}
