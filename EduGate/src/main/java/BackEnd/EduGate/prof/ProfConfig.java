package BackEnd.EduGate.prof;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfConfig {
        @Bean
        CommandLineRunner commandLineRunner(
                        ProfRepository repository) {
                return args -> {
                        Prof Jad = new Prof(
                                        "jad",
                                        "jad.c.breckinridge@altostrat.com");
                        Prof Latif = new Prof(
                                        "latif",
                                        "latif.c.breckinridge@altostrat.com");

                        repository.saveAll(
                                        List.of(Jad, Latif));
                };
        }
}
