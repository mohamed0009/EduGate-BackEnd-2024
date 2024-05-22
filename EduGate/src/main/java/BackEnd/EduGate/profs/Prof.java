package BackEnd.EduGate.profs;

import BackEnd.EduGate.user.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "enseignant")
public class Prof {

    @Id
    @Column(name = "id_enseignant")
    private Long idProf;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_enseignant")
    private Utilisateur utilisateur;

    // Default constructor
    public Prof() {
    }

    // Constructor with parameters
    public Prof(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public Long getIdProf() {
        return idProf;
    }

    public void setIdProf(Long idProf) {
        this.idProf = idProf;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
