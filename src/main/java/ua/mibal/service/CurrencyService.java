package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.controller.model.CurrencyDto;
import ua.mibal.exception.BadRequestException;
import ua.mibal.exception.NotFoundException;
import ua.mibal.model.Currency;
import ua.mibal.repository.CurrencyRepository;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class CurrencyService {
    private final CurrencyRepository repository;
    private final CurrencyRepository currencyRepository;

    public Currency getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Currency not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Currency create(CurrencyDto currency) {
        if (currencyRepository.existsByName(currency.name())) {
            throw new BadRequestException("Currency already exists");
        }
        return repository.save(Currency.builder()
                .name(currency.name())
                .build());
    }

    public List<Currency> getAll() {
        return repository.findAll();
    }

    public Currency getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Currency not found"));
    }
}
