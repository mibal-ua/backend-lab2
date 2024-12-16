package ua.mibal.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.controller.model.UserDto;
import ua.mibal.exception.NotFoundException;
import ua.mibal.model.User;
import ua.mibal.repository.CurrencyRepository;
import ua.mibal.repository.UserRepository;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;
    private final CurrencyRepository currencyRepository;

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User create(@Valid UserDto user) {
        validateEmailUnique(user.email());
        return repository.save(User.builder()
                .name(user.name())
                .defaultCurrency(
                        currencyRepository.findById(user.defaultCurrencyId())
                                .orElseThrow(() -> new NotFoundException("Currency not found"))
                )
                .build());
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    private void validateEmailUnique(@NotBlank String email) {
        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("User with email already exists");
        }
    }
}
