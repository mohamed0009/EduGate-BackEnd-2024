package BackEnd.EduGate.profs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfController {

    private final ProfService profService;

    @Autowired
    public ProfController(ProfService profService) {
        this.profService = profService;
    }

    @GetMapping("/api/v1/prof")
    public List<ProfDTO> getProfs() {
        return profService.getProfs();
    }

    @PostMapping("/api/v1/prof")
    public void registerNewProf(@RequestBody Prof prof) {
        profService.addNewProf(prof);
    }

    @DeleteMapping("/api/v1/prof/{profId}")
    public void deleteProf(@PathVariable("profId") Long profId) {
        profService.deleteProf(profId);
    }
}
