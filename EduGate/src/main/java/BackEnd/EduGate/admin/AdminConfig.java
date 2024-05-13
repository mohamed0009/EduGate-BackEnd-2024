package BackEnd.EduGate.admin;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
        @Bean
        CommandLineRunner commandLineRunner(
                        AdminRepository repository) {
                return args -> {
                        Admin John = new Admin(
                                        "mohamed",
                                        "mohamed.c.idrissi@altostrat.com");
                        Admin Ali = new Admin(
                                        "Hiba",
                                        "hiba.c.ghallabi@altostrat.com");

                        repository.saveAll(
                                        List.of(John, Ali));
                };
        }
}
