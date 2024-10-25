package ua.mibal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.mibal.model.Category;
import ua.mibal.model.Record;
import ua.mibal.model.User;
import ua.mibal.repository.CategoryRepository;
import ua.mibal.repository.RecordRepository;
import ua.mibal.repository.UserRepository;

import static java.time.LocalDateTime.now;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner setup(UserRepository userRepository,
                                   CategoryRepository categoryRepository,
                                   RecordRepository recordRepository) {
        return (args) -> {
            User me = new User("Mykhailo Balakhon");
            userRepository.save(me);

            Category thriller = new Category("Thriller");
            categoryRepository.save(thriller);

            Record buying = new Record(
                    me.getId(), thriller.getId(), now(), 100_500L
            );
            recordRepository.save(buying);
        };
    }
}
