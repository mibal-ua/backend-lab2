package ua.mibal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "records")
public class Record implements WithId {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private Long amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public Record(Long id, User user, Category category, LocalDateTime timestamp, Long amount, Currency currency) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.timestamp = timestamp;
        this.amount = amount;
        if (currency == null) {
            this.currency = user.getDefaultCurrency();
        } else {
            this.currency = currency;
        }
    }

    @Override
    public String toString() {
        return "Record{" +
               "id=" + id +
               ", user=" + user +
               ", category=" + category +
               ", timestamp=" + timestamp +
               ", amount=" + amount +
               ", currency=" + currency +
               '}';
    }
}
