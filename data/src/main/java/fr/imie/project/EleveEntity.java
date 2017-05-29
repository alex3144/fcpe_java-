package fr.imie.project;

import javax.persistence.*;
import java.util.List;

/**
 * Created by max on 29/05/2017.
 */
@Entity
@Table(name = "eleve", schema = "public", catalog = "fcpe")
public class EleveEntity {
    private String nom;
    private String prenom;
    private Boolean present;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="id", updatable = false,insertable = false)
    private ClasseEntity id_classe;
    public ClasseEntity getId_classe() {
        return id_classe;
    }
    public void setId_classe(ClasseEntity id_classe) {
        this.id_classe = id_classe;
    }

    @ManyToMany
    @JoinTable(
            name="_etrereponsable",
            joinColumns=@JoinColumn(name="id_eleve", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id", referencedColumnName="id"))
    private List<ParentEntity> parents;

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "present")
    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleveEntity that = (EleveEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (present != null ? !present.equals(that.present) : that.present != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (present != null ? present.hashCode() : 0);
        return result;
    }


}
