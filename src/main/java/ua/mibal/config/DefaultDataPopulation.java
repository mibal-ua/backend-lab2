package ua.mibal.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.mibal.controller.model.CurrencyDto;
import ua.mibal.exception.BadRequestException;
import ua.mibal.model.Category;
import ua.mibal.model.Currency;
import ua.mibal.model.Record;
import ua.mibal.model.User;
import ua.mibal.repository.CategoryRepository;
import ua.mibal.repository.RecordRepository;
import ua.mibal.repository.UserRepository;
import ua.mibal.service.CurrencyService;

import static java.time.LocalDateTime.now;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class DefaultDataPopulation {
    private final CurrencyService currencyService;

    @Bean
    public CommandLineRunner setup(UserRepository userRepository,
                                   CategoryRepository categoryRepository,
                                   RecordRepository recordRepository) {
        return (args) -> {
            populateDefaultCurrencies();

            Currency usd = currencyService.getByName("USD");

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
        try {
            Currency uah = currencyService.create(CurrencyDto.builder()
                    .name("UAH")
                    .build());
            log.info("Currency saved: {}", uah);
        } catch (BadRequestException e) {
            
        }

        try {
            Currency usd = currencyService.create(CurrencyDto.builder()
                    .name("USD")
                    .build());
            log.info("Currency saved: {}", usd);
        } catch (BadRequestException e) {

        }
    }
}
