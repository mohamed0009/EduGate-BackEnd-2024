package BackEnd.EduGate.notes;

public class NoteDTO {

    private Long idNote;
    private String matiere;
    private Float note;
    private Long eleveId;
    private String eleveNomClasse; 
    private Long enseignantId;
    private String enseignantNom;

    public NoteDTO() {
    }

    public NoteDTO(Long idNote, String matiere, Float note, Long eleveId, String eleveNomClasse, Long enseignantId,
            String enseignantNom) {
        this.idNote = idNote;
        this.matiere = matiere;
        this.note = note;
        this.eleveId = eleveId;
        this.eleveNomClasse = eleveNomClasse;
        this.enseignantId = enseignantId;
        this.enseignantNom = enseignantNom;
    }

    public Long getIdNote() {
        return idNote;
    }

    public void setIdNote(Long idNote) {
        this.idNote = idNote;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Long getEleveId() {
        return eleveId;
    }

    public void setEleveId(Long eleveId) {
        this.eleveId = eleveId;
    }

    public String getEleveNomClasse() {
        return eleveNomClasse;
    }

    public void setEleveNomClasse(String eleveNomClasse) {
        this.eleveNomClasse = eleveNomClasse;
    }

    public Long getEnseignantId() {
        return enseignantId;
    }

    public void setEnseignantId(Long enseignantId) {
        this.enseignantId = enseignantId;
    }

    public String getEnseignantNom() {
        return enseignantNom;
    }

    public void setEnseignantNom(String enseignantNom) {
        this.enseignantNom = enseignantNom;
    }
}
