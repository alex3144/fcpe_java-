package fr.imie.project;

import javax.persistence.*;
import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Question.findAll", query = "SELECT q FROM QuestionEntity q"),
        @NamedQuery(name = "Question.findOne", query = "SELECT q FROM QuestionEntity q WHERE q.id =:id"),
})
@Table(name = "question", schema = "public", catalog = "fcpe")

public class QuestionEntity {

    private String intitule;
    private String type;
    private String choixreponse1;
    private String choixreponse2;
    private String choixreponse3;
    private String choixreponse4;
    private String aide;
    private Boolean estactif;
    private Boolean estverrouille;


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "id")
    @OneToMany(fetch=FetchType.EAGER)
    private List<QuestionEntity> questionnaires;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "intitule")
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "choixreponse1")
    public String getChoixreponse1() {
        return choixreponse1;
    }

    public void setChoixreponse1(String choixreponse1) {
        this.choixreponse1 = choixreponse1;
    }

    @Basic
    @Column(name = "choixreponse2")
    public String getChoixreponse2() {
        return choixreponse2;
    }

    public void setChoixreponse2(String choixreponse2) {
        this.choixreponse2 = choixreponse2;
    }

    @Basic
    @Column(name = "choixreponse3")
    public String getChoixreponse3() {
        return choixreponse3;
    }

    public void setChoixreponse3(String choixreponse3) {
        this.choixreponse3 = choixreponse3;
    }

    @Basic
    @Column(name = "choixreponse4")
    public String getChoixreponse4() {
        return choixreponse4;
    }

    public void setChoixreponse4(String choixreponse4) {
        this.choixreponse4 = choixreponse4;
    }

    @Basic
    @Column(name = "aide")
    public String getAide() {
        return aide;
    }

    public void setAide(String aide) {
        this.aide = aide;
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

        QuestionEntity that = (QuestionEntity) o;

        if (id != that.id) return false;
        if (intitule != null ? !intitule.equals(that.intitule) : that.intitule != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (choixreponse1 != null ? !choixreponse1.equals(that.choixreponse1) : that.choixreponse1 != null)
            return false;
        if (choixreponse2 != null ? !choixreponse2.equals(that.choixreponse2) : that.choixreponse2 != null)
            return false;
        if (choixreponse3 != null ? !choixreponse3.equals(that.choixreponse3) : that.choixreponse3 != null)
            return false;
        if (choixreponse4 != null ? !choixreponse4.equals(that.choixreponse4) : that.choixreponse4 != null)
            return false;
        if (aide != null ? !aide.equals(that.aide) : that.aide != null) return false;
        if (estactif != null ? !estactif.equals(that.estactif) : that.estactif != null) return false;
        if (estverrouille != null ? !estverrouille.equals(that.estverrouille) : that.estverrouille != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (intitule != null ? intitule.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (choixreponse1 != null ? choixreponse1.hashCode() : 0);
        result = 31 * result + (choixreponse2 != null ? choixreponse2.hashCode() : 0);
        result = 31 * result + (choixreponse3 != null ? choixreponse3.hashCode() : 0);
        result = 31 * result + (choixreponse4 != null ? choixreponse4.hashCode() : 0);
        result = 31 * result + (aide != null ? aide.hashCode() : 0);
        result = 31 * result + (estactif != null ? estactif.hashCode() : 0);
        result = 31 * result + (estverrouille != null ? estverrouille.hashCode() : 0);
        return result;
    }
}
