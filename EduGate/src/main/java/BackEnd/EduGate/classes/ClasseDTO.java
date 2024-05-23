package BackEnd.EduGate.classes;

public class ClasseDTO {

    private Long idClasse;
    private String nomClasse;
    private String niveau;

    public ClasseDTO() {
    }

    public ClasseDTO(Long idClasse, String nomClasse, String niveau) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.niveau = niveau;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}