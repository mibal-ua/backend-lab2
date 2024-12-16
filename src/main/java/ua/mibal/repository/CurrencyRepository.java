package ua.mibal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mibal.model.Currency;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
