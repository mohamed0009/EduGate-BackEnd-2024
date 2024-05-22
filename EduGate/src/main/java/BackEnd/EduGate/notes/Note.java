package BackEnd.EduGate.notes;

import BackEnd.EduGate.students.Student;
import BackEnd.EduGate.profs.Prof;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Long idNote;

    @Column(name = "matière", length = 30)
    private String matiere;

    @Column(name = "note")
    private Float note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "élève_id")
    private Student eleve;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enseignant_id")
    private Prof enseignant;

    public Note() {
    }

    public Note(String matiere, Float note, Student eleve, Prof enseignant) {
        this.matiere = matiere;
        this.note = note;
        this.eleve = eleve;
        this.enseignant = enseignant;
    }

    // Getters and Setters
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

    public Student getEleve() {
        return eleve;
    }

    public void setEleve(Student eleve) {
        this.eleve = eleve;
    }

    public Prof getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Prof enseignant) {
        this.enseignant = enseignant;
    }
}
