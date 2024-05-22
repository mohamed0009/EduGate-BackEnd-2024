package BackEnd.EduGate.profs;

public class ProfDTO {

    private Long idProf;
    private String nom;
    private String email;

    // Constructors
    public ProfDTO() {
    }

    public ProfDTO(Long idProf, String nom, String email) {
        this.idProf = idProf;
        this.nom = nom;
        this.email = email;
    }

    // Getters and Setters
    public Long getIdProf() {
        return idProf;
    }

    public void setIdProf(Long idProf) {
        this.idProf = idProf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
