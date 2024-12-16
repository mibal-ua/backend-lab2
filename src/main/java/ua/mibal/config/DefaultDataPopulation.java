package ua.mibal.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.mibal.model.Category;
import ua.mibal.model.Currency;
import ua.mibal.model.Record;
import ua.mibal.model.User;
import ua.mibal.repository.CategoryRepository;
import ua.mibal.repository.CurrencyRepository;
import ua.mibal.repository.RecordRepository;
import ua.mibal.repository.UserRepository;

import static java.time.LocalDateTime.now;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class DefaultDataPopulation {
    private final CurrencyRepository currencyRepository;

    @Bean
    public CommandLineRunner setup(UserRepository userRepository,
                                   CategoryRepository categoryRepository,
                                   RecordRepository recordRepository) {
        return (args) -> {
            populateDefaultCurrencies();

            Currency usd = currencyRepository.findByName("USD")
                    .orElseThrow();

            User me = User.builder()
                    .name("Mykhailo Balakhon")
                    .defaultCurrency(usd)
                    .build();
            userRepository.save(me);
            log.info("User saved: {}", me);

            Category thriller = Category.builder()
                    .name("Thriller")
                    .build();
            categoryRepository.save(thriller);
            log.info("Category saved: {}", thriller);

            Record buying = Record.builder()
                    .user(me)
                    .category(thriller)
                    .timestamp(now())
                    .amount(100_500L)
                    .build();
            recordRepository.save(buying);
            log.info("Record saved: {}", buying);
        };
    }

    private void populateDefaultCurrencies() {
        Currency uah = Currency.builder()
                .name("UAH")
                .build();
        currencyRepository.save(uah);
        log.info("Currency saved: {}", uah);

        Currency usd = Currency.builder()
                .name("USD")
                .build();
        currencyRepository.save(usd);
        log.info("Currency saved: {}", usd);
    }
}
