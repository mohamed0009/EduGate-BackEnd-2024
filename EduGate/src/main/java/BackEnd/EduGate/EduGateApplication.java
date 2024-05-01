package BackEnd.EduGate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class EduGateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduGateApplication.class, args);
	}
	@GetMapping
    public List<String> hello(){
		return List.of("hello","EduGate");
	}
}
