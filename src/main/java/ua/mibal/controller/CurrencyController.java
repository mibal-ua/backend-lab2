package ua.mibal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.controller.model.CurrencyDto;
import ua.mibal.model.Currency;
import ua.mibal.service.CurrencyService;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/currencies")
public class CurrencyController {
    private final CurrencyService service;

    @GetMapping("/{id}")
    public Currency get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/by-name/{name}")
    public Currency get(@PathVariable String name) {
        return service.getByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping
    public Currency create(@Valid @RequestBody CurrencyDto currency) {
        return service.create(currency);
    }

    @GetMapping
    public List<Currency> getAll() {
        return service.getAll();
    }
}
