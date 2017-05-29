package fr.imie.project;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


/**
 * Created by fred on 17/05/17.
 */
@Entity
@NamedQueries({

        @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM EtablissementEntity e"),
        @NamedQuery(name = "Etablissement.findOne", query = "SELECT e FROM EtablissementEntity e WHERE e.id =:id"),
        //requete sql de toutes les campagnes d'un etablissement
        @NamedQuery(name = "Etablissement.findAllCampagnes", query = "SELECT c FROM CampagneEntity c JOIN c.classe cl JOIN cl.etablissement e WHERE e.id=:idEtab AND cl.id = :idClass"),
        @NamedQuery(name = "Etablissement.findOneCampagnes", query = " SELECT c FROM CampagneEntity c JOIN c.classe cl JOIN cl.etablissement e WHERE e.id=:idEtab AND cl.id = :idClass AND c.id = :idCamp"),
        @NamedQuery(name = "Etablissement.findQuestionnaire", query = "SELECT qe FROM CampagneEntity c JOIN c.questionnaire qe JOIN c.classe cl JOIN cl.etablissement e WHERE e.id=:idEtab AND cl.id = :idClass AND c.id = :idCamp "),
        @NamedQuery(name = "Etablissement.findQuestions", query="SELECT qn FROM CampagneEntity c JOIN c.questionnaire qe JOIN qe.questions qn JOIN c.classe cl JOIN cl.etablissement e WHERE e.id= :idEtab AND cl.id = :idClass AND c.id = :idCamp"),
        @NamedQuery(name = "Etablissement.findQuestion", query="SELECT qn FROM CampagneEntity c JOIN c.questionnaire qe JOIN qe.questions qn JOIN c.classe cl JOIN cl.etablissement e WHERE e.id=:idEtab AND cl.id = :idClass AND c.id = :idCamp AND qn.id  = :idqn")
})

@Table(name = "etablissement", schema = "public", catalog = "fcpe")


public class EtablissementEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nom;
    private String numrue;
    private String nomrue;
    private Integer cp;
    private String ville;
    private String departement;
    private String academie;
    private String typeetablissement;



    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="id")
    private List<ClasseEntity> classes;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="id")
    private List<QuestionnaireEntity> questionnaire;


    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "numrue")
    public String getNumrue() {
        return numrue;
    }

    public void setNumrue(String numrue) {
        this.numrue = numrue;
    }

    @Basic
    @Column(name = "nomrue")
    public String getNomrue() {
        return nomrue;
    }

    public void setNomrue(String nomrue) {
        this.nomrue = nomrue;
    }

    @Basic
    @Column(name = "cp")
    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "departement")
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Basic
    @Column(name = "academie")
    public String getAcademie() {
        return academie;
    }

    public void setAcademie(String academie) {
        this.academie = academie;
    }

    @Basic
    @Column(name = "typeetablissement")
    public String getTypeetablissement() {
        return typeetablissement;
    }

    public void setTypeetablissement(String typeetablissement) {
        this.typeetablissement = typeetablissement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtablissementEntity that = (EtablissementEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (numrue != null ? !numrue.equals(that.numrue) : that.numrue != null) return false;
        if (nomrue != null ? !nomrue.equals(that.nomrue) : that.nomrue != null) return false;
        if (cp != null ? !cp.equals(that.cp) : that.cp != null) return false;
        if (ville != null ? !ville.equals(that.ville) : that.ville != null) return false;
        if (departement != null ? !departement.equals(that.departement) : that.departement != null) return false;
        if (academie != null ? !academie.equals(that.academie) : that.academie != null) return false;
        if (typeetablissement != null ? !typeetablissement.equals(that.typeetablissement) : that.typeetablissement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (numrue != null ? numrue.hashCode() : 0);
        result = 31 * result + (nomrue != null ? nomrue.hashCode() : 0);
        result = 31 * result + (cp != null ? cp.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (departement != null ? departement.hashCode() : 0);
        result = 31 * result + (academie != null ? academie.hashCode() : 0);
        result = 31 * result + (typeetablissement != null ? typeetablissement.hashCode() : 0);
        return result;
    }


}
