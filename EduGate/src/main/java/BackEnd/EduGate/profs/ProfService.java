package BackEnd.EduGate.profs;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfService {

    private final ProfRepository profRepository;

    @Autowired
    public ProfService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }

    public List<ProfDTO> getProfs() {
        return profRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void addNewProf(Prof prof) {
        profRepository.save(prof);
    }

    public void deleteProf(Long profId) {
        boolean exists = profRepository.existsById(profId);
        if (!exists) {
            throw new IllegalStateException("Prof with id " + profId + " does not exist.");
        }
        profRepository.deleteById(profId);
    }

    private ProfDTO convertToDTO(Prof prof) {
        return new ProfDTO(prof.getIdProf(), prof.getUtilisateur().getNom(), prof.getUtilisateur().getEmail());
    }
}
