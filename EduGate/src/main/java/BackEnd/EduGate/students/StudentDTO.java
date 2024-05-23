package BackEnd.EduGate.students;

import BackEnd.EduGate.classes.ClasseDTO;

public class StudentDTO {

    private Long idEleve;
    private ClasseDTO classe;

    public StudentDTO() {
    }

    public StudentDTO(Long idEleve, ClasseDTO classe) {
        this.idEleve = idEleve;
        this.classe = classe;
    }

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    public ClasseDTO getClasse() {
        return classe;
    }

    public void setClasse(ClasseDTO classe) {
        this.classe = classe;
    }
}
