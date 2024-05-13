package BackEnd.EduGate.prof;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Long> {
    @Query("SELECT s FROM Prof s WHERE s.email = ?1")
    Optional<Prof> findProfByEmail(String email);
}
