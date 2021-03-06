package fr.imie.project;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by fred on 22/05/17.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Classe.findAllClasse", query = "SELECT c FROM EtablissementEntity e JOIN e.classes c WHERE c.etablissement.id = :id"),
        @NamedQuery(name = "Classe.findOneClasse", query = "SELECT c FROM ClasseEntity c INNER JOIN EtablissementEntity e  WHERE e.id = :idEtab AND c.id = :idClasse"),
})
@Table(name = "classe", schema = "public", catalog = "fcpe")

public class ClasseEntity implements Serializable {

    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    List<CampagneEntity> campagnes;
    private String nom;
    private String nomprenomprofprincipal;
    private String nomprenomparentdelegue;
    private String niveauclasse;
    private String serieclasse;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name="id_etablissement", updatable = false,insertable = false)
    private EtablissementEntity etablissement;
    public EtablissementEntity getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(EtablissementEntity etablissement) {
        this.etablissement = etablissement;
    }


    @OneToMany(mappedBy = "id_classe")
    List<EleveEntity> eleves;

    public List<EleveEntity> getEleves() {
        return eleves;
    }

    public void setEleves(List<EleveEntity> eleves) {
        this.eleves = eleves;
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
