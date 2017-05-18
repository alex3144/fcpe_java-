package fr.imie.project;

import javax.persistence.*;

/**
 * Created by fred on 18/05/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM ClasseEntity c"),
        @NamedQuery(name = "Classe.findOne", query = "SELECT c FROM ClasseEntity c WHERE c.id =:id"),
})
@Table(name = "classe", schema = "public", catalog = "fcpe")
public class ClasseEntity {
    private int id;
    private String nom;
    private String nomprenomprofprincipal;
    private String nomprenomparentdelegue;
    private String niveauclasse;
    private String serieclasse;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "nomprenomprofprincipal")
    public String getNomprenomprofprincipal() {
        return nomprenomprofprincipal;
    }

    public void setNomprenomprofprincipal(String nomprenomprofprincipal) {
        this.nomprenomprofprincipal = nomprenomprofprincipal;
    }

    @Basic
    @Column(name = "nomprenomparentdelegue")
    public String getNomprenomparentdelegue() {
        return nomprenomparentdelegue;
    }

    public void setNomprenomparentdelegue(String nomprenomparentdelegue) {
        this.nomprenomparentdelegue = nomprenomparentdelegue;
    }

    @Basic
    @Column(name = "niveauclasse")
    public String getNiveauclasse() {
        return niveauclasse;
    }

    public void setNiveauclasse(String niveauclasse) {
        this.niveauclasse = niveauclasse;
    }

    @Basic
    @Column(name = "serieclasse")
    public String getSerieclasse() {
        return serieclasse;
    }

    public void setSerieclasse(String serieclasse) {
        this.serieclasse = serieclasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClasseEntity that = (ClasseEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (nomprenomprofprincipal != null ? !nomprenomprofprincipal.equals(that.nomprenomprofprincipal) : that.nomprenomprofprincipal != null)
            return false;
        if (nomprenomparentdelegue != null ? !nomprenomparentdelegue.equals(that.nomprenomparentdelegue) : that.nomprenomparentdelegue != null)
            return false;
        if (niveauclasse != null ? !niveauclasse.equals(that.niveauclasse) : that.niveauclasse != null) return false;
        if (serieclasse != null ? !serieclasse.equals(that.serieclasse) : that.serieclasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (nomprenomprofprincipal != null ? nomprenomprofprincipal.hashCode() : 0);
        result = 31 * result + (nomprenomparentdelegue != null ? nomprenomparentdelegue.hashCode() : 0);
        result = 31 * result + (niveauclasse != null ? niveauclasse.hashCode() : 0);
        result = 31 * result + (serieclasse != null ? serieclasse.hashCode() : 0);
        return result;
    }
}
