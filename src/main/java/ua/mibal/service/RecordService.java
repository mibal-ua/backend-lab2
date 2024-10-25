package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.exception.BadRequestException;
import ua.mibal.exception.NotFoundException;
import ua.mibal.model.Record;
import ua.mibal.model.RecordSearchQuery;
import ua.mibal.repository.RecordRepository;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class RecordService {
    private final RecordRepository repository;

    public Record getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Record not found"));
    }

    public Record deleteById(Long id) {
        return repository.deleteById(id)
                .orElseThrow(() -> new NotFoundException("Record not found"));
    }

    public Record create(Record record) {
        return repository.save(record);
    }

    public List<Record> getAll() {
        return repository.findAll();
    }

    public List<Record> searchBy(RecordSearchQuery query) {
        validate(query);
        return repository.findByQuery(query);
    }

    private void validate(RecordSearchQuery query) {
        if (query.userId() == null && query.categoryId() == null) {
            throw new BadRequestException("At least one parameter should be provided");
        }
    }
}
