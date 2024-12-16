package ua.mibal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "currencies")
public class Currency {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    
    public Currency(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
