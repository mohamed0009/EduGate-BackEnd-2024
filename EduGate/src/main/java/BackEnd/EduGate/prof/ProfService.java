package BackEnd.EduGate.prof;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProfService {
    private final ProfRepository profRepository;

    @Autowired
    public ProfService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }

    public List<Prof> getProfs() {
        return profRepository.findAll();
    }

    public void addNewProf(Prof prof) {
        Optional<Prof> profByEmail = profRepository.findProfByEmail(prof.getEmail());
        System.out.println(prof);
        if (profByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        profRepository.save(prof);
    }

    public void deleteProf(Long profId) {
        boolean exists = profRepository.existsById(profId);
        if (exists) {
            profRepository.deleteById(profId);
        } else {
            throw new IllegalStateException("Prof with id " + profId + " not found ");
        }
    }

    @Transactional
    public void updateProf(Long profId,
            String name,
            String email) {
        Prof prof = profRepository.findById(profId).orElseThrow(
                () -> new IllegalStateException(
                        "Prof with id " + profId + " not found "));

        ;
        if (name != null && name.length() > 0
                && !Objects.equals(prof.getName(),
                        name)) {
            prof.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(prof.getEmail(), email)) {
            Optional<Prof> profByEmail = profRepository.findProfByEmail(email);
            if (profByEmail.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            prof.setEmail(email);

        }

    }

}
