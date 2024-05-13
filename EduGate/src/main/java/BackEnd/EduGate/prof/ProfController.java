package BackEnd.EduGate.prof;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/prof")
public class ProfController {

    private final ProfService profService;

    @Autowired
    public ProfController(ProfService profService) {
        this.profService = profService;
    }

    @GetMapping
    public List<Prof> getProfS() {
        return profService.getProfs();
    }

    @PostMapping
    public Void registerNewProf(@RequestBody Prof prof) {
        profService.addNewProf(prof);
        return null;
    }

    @DeleteMapping(path = "{profId}")
    public void deleteProf(@PathVariable("profId") Long profId) {
        profService.deleteProf(profId);
    }

    @PutMapping(path = "{profId}")
    public void updateProf(
            @PathVariable("profId") Long profId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                profService.updateProf(profId, name, email);

    }

}
