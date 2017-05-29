package fr.imie.project;

import javax.persistence.*;
import java.util.List;

/**
 * Created by max on 29/05/2017.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Parent.findEmails", query = " SELECT p FROM EleveEntity e JOIN e.parents p WHERE e.id_classe.id = :idClass "),
})
@Table(name = "parent", schema = "public", catalog = "fcpe")
public class ParentEntity {

    private String nom;
    private String prenom;
    private String email;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany
    @JoinTable(name="_etrereponsable",
            joinColumns=@JoinColumn(name="id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id_eleve", referencedColumnName="id"))
    private List<EleveEntity> eleves;

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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentEntity that = (ParentEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
