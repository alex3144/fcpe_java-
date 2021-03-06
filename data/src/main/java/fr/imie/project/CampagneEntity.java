package fr.imie.project;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Campagne.findAll", query = "SELECT c FROM CampagneEntity c"),
        @NamedQuery(name = "Campagne.findOne", query = "SELECT c FROM CampagneEntity c WHERE c.id =:id"),
})

@Table(name = "campagne", schema = "public", catalog = "fcpe")
public class CampagneEntity {

    private String nom;
    private Timestamp datefin;
    private String nomconsclasse;
    private String trimconsclasse;
    private Timestamp dateconsclasse;
    private String statut;
    private String urlcollective;



    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClasseEntity getClasses() {
        return classe;
    }

    public void setClasses(ClasseEntity classes) {
        this.classe = classes;
    }

    public QuestionnaireEntity getQuestionnaires() {
        return questionnaire;
    }

    public void setQuestionnaires(QuestionnaireEntity questionnaire) {
        this.questionnaire = questionnaire;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_classe", referencedColumnName="id")
    private ClasseEntity classe;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_questionnaire", referencedColumnName="id")
    private QuestionnaireEntity questionnaire;


    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "datefin")
    public Timestamp getDatefin() {
        return datefin;
    }

    public void setDatefin(Timestamp datefin) {
        this.datefin = datefin;
    }

    @Basic
    @Column(name = "nomconsclasse")
    public String getNomconsclasse() {
        return nomconsclasse;
    }

    public void setNomconsclasse(String nomconsclasse) {
        this.nomconsclasse = nomconsclasse;
    }

    @Basic
    @Column(name = "trimconsclasse")
    public String getTrimconsclasse() {
        return trimconsclasse;
    }

    public void setTrimconsclasse(String trimconsclasse) {
        this.trimconsclasse = trimconsclasse;
    }

    @Basic
    @Column(name = "dateconsclasse")
    public Timestamp getDateconsclasse() {
        return dateconsclasse;
    }

    public void setDateconsclasse(Timestamp dateconsclasse) {
        this.dateconsclasse = dateconsclasse;
    }

    @Basic
    @Column(name = "statut")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Basic
    @Column(name = "urlcollective")
    public String getUrlcollective() {
        return urlcollective;
    }

    public void setUrlcollective(String urlcollective) {
        this.urlcollective = urlcollective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CampagneEntity that = (CampagneEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (datefin != null ? !datefin.equals(that.datefin) : that.datefin != null) return false;
        if (nomconsclasse != null ? !nomconsclasse.equals(that.nomconsclasse) : that.nomconsclasse != null)
            return false;
        if (trimconsclasse != null ? !trimconsclasse.equals(that.trimconsclasse) : that.trimconsclasse != null)
            return false;
        if (dateconsclasse != null ? !dateconsclasse.equals(that.dateconsclasse) : that.dateconsclasse != null)
            return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;
        if (urlcollective != null ? !urlcollective.equals(that.urlcollective) : that.urlcollective != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (datefin != null ? datefin.hashCode() : 0);
        result = 31 * result + (nomconsclasse != null ? nomconsclasse.hashCode() : 0);
        result = 31 * result + (trimconsclasse != null ? trimconsclasse.hashCode() : 0);
        result = 31 * result + (dateconsclasse != null ? dateconsclasse.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (urlcollective != null ? urlcollective.hashCode() : 0);
        return result;
    }
}