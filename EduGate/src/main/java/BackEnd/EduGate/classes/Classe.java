package BackEnd.EduGate.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe {

    @Id
    @Column(name = "id_classe")
    private Long id_classe;

    @Column(name = "nom_classe")
    private String nom_classe;

    @Column(name = "niveau")
    private String niveau;

    public Classe() {
    }

    public Classe(Long id_classe, String nom_classe, String niveau) {
        this.id_classe = id_classe;
        this.nom_classe = nom_classe;
        this.niveau = niveau;
    }

    public Long getIdClasse() {
        return id_classe;
    }

    public void setIdClasse(Long id_classe) {
        this.id_classe = id_classe;
    }

    public String getNomClasse() {
        return nom_classe;
    }

    public void setNomClasse(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Classe [id_classe=" + id_classe + ", nom_classe=" + nom_classe + ", niveau=" + niveau + "]";
    }
}
