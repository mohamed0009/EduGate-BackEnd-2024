package BackEnd.EduGate.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student John = new Student(
                    "John",
                    "john.c.breckinridge@altostrat.com",
                    LocalDate.of(2000, 1, 5));
            Student Ali = new Student(
                    "Ali",
                    "ali.c.breckinridge@altostrat.com",
                    LocalDate.of(2001, 3, 7));

            repository.saveAll(
                    List.of(John, Ali));
        };
    }
}
