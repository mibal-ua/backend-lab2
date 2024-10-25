package ua.mibal.repository;

import org.springframework.stereotype.Repository;
import ua.mibal.model.Record;
import ua.mibal.model.RecordSearchQuery;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Repository
public class RecordRepository extends InMemoryRepository<Record> {

    public List<Record> findByQuery(RecordSearchQuery query) {
        return entities.stream()
                .filter(record -> query.userId() == null
                                  || query.userId().equals(record.getUserId()))
                .filter(record -> query.categoryId() == null
                                  || query.categoryId().equals(record.getCategoryId()))
                .toList();
    }
}
