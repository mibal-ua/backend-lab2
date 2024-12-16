package ua.mibal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@NoArgsConstructor
@Getter
@Setter
public class Currency {
    private Long id;
    private String name;
    
    public Currency(String name) {
        this.name = name;
    }
}
