package fr.imie.project;

import javax.persistence.*;
import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Questionnaire.findAll", query = "SELECT q FROM QuestionnaireEntity q"),
        @NamedQuery(name = "Questionnaire.findOne", query = "SELECT q FROM QuestionnaireEntity q WHERE q.id =:id"),

})
@Table(name = "questionnaire", schema = "public", catalog = "fcpe")

public class QuestionnaireEntity {

    private String nom;
    private Boolean estactif;
    private Boolean estverrouille;



    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    List<QuestionEntity> questions;

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<CampagneEntity> campagnes;

    public List<CampagneEntity> getCampagnes() {
        return campagnes;
    }

    public void setCampagnes(List<CampagneEntity> campagnes) {
        this.campagnes = campagnes;
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

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "estactif")
    public Boolean getEstactif() {
        return estactif;
    }

    public void setEstactif(Boolean estactif) {
        this.estactif = estactif;
    }

    @Basic
    @Column(name = "estverrouille")
    public Boolean getEstverrouille() {
        return estverrouille;
    }

    public void setEstverrouille(Boolean estverrouille) {
        this.estverrouille = estverrouille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionnaireEntity that = (QuestionnaireEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (estactif != null ? !estactif.equals(that.estactif) : that.estactif != null) return false;
        if (estverrouille != null ? !estverrouille.equals(that.estverrouille) : that.estverrouille != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (estactif != null ? estactif.hashCode() : 0);
        result = 31 * result + (estverrouille != null ? estverrouille.hashCode() : 0);
        return result;
    }
}
