package ua.mibal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.mibal.model.Category;
import ua.mibal.model.Currency;
import ua.mibal.model.Record;
import ua.mibal.model.User;
import ua.mibal.repository.CategoryRepository;
import ua.mibal.repository.CurrencyRepository;
import ua.mibal.repository.RecordRepository;
import ua.mibal.repository.UserRepository;

import static java.time.LocalDateTime.now;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner setup(CurrencyRepository currencyRepository,
                                   UserRepository userRepository,
                                   CategoryRepository categoryRepository,
                                   RecordRepository recordRepository) {
        return (args) -> {
            Currency usd = Currency.builder()
                    .name("USD")
                    .build();
            currencyRepository.save(usd);
            log.info("Currency saved: {}", usd);
            
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
}
