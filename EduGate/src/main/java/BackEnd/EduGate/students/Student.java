package BackEnd.EduGate.students;

import BackEnd.EduGate.classes.Classe;
import jakarta.persistence.*;

@Entity
@Table(name = "eleve")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eleve")
    private Long idEleve;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe_id", referencedColumnName = "id_classe")
    private Classe classe;

    public Student() {
    }

    public Student(Classe classe) {
        this.classe = classe;
    }

    public Student(Long idEleve, Classe classe) {
        this.idEleve = idEleve;
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Student [idEleve=" + idEleve + ", classe=" + classe + "]";
    }

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
