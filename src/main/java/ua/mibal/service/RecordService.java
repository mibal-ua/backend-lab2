package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.controller.model.RecordDto;
import ua.mibal.exception.BadRequestException;
import ua.mibal.exception.NotFoundException;
import ua.mibal.model.Record;
import ua.mibal.model.RecordSearchQuery;
import ua.mibal.repository.CurrencyRepository;
import ua.mibal.repository.RecordRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class RecordService {
    private final RecordRepository repository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrencyRepository currencyRepository;

    public Record getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Record not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Record create(RecordDto record) {
        return repository.save(
                Record.builder()
                        .user(userService.getById(record.userId()))
                        .category(categoryService.getById(record.categoryId()))
                        .amount(record.amount())
                        .timestamp(LocalDateTime.now())
                        .currency(
                                Optional.ofNullable(record.currencyId())
                                        .flatMap(currencyRepository::findById)
                                        .orElse(null)
                        )
                        .build()
        );
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
