package ua.mibal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mibal.model.Record;
import ua.mibal.model.RecordSearchQuery;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface RecordRepository extends JpaRepository<Record, Long> {

    default List<Record> findByQuery(RecordSearchQuery query) {
        return findAll().stream()
                .filter(record -> query.userId() == null
                                  || query.userId().equals(record.getUser().getId()))
                .filter(record -> query.categoryId() == null
                                  || query.categoryId().equals(record.getCategory().getId()))
                .toList();
    }
}
