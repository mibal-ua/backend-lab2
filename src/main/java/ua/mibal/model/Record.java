package ua.mibal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Record implements WithId {
    private Long id;
    private Long userId;
    private Long categoryId;
    private LocalDateTime timestamp;
    private Long amount;
}
