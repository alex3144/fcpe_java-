package fr.imie.project.question;
import fr.imie.project.QuestionEntity;

/**
 * Created by fred on 16/05/17.
 */
public class QuestionBO {
    private int id;
    private String intitule;
    private String type;
    private String choixreponse1;
    private String choixreponse2;
    private String choixreponse3;
    private String choixreponse4;
    private String aide;
    private Boolean estactif;
    private Boolean estverrouille;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChoixreponse1() {
        return choixreponse1;
    }

    public void setChoixreponse1(String choixreponse1) {
        this.choixreponse1 = choixreponse1;
    }

    public String getChoixreponse2() {
        return choixreponse2;
    }

    public void setChoixreponse2(String choixreponse2) {
        this.choixreponse2 = choixreponse2;
    }

    public String getChoixreponse3() {
        return choixreponse3;
    }

    public void setChoixreponse3(String choixreponse3) {
        this.choixreponse3 = choixreponse3;
    }

    public String getChoixreponse4() {
        return choixreponse4;
    }

    public void setChoixreponse4(String choixreponse4) {
        this.choixreponse4 = choixreponse4;
    }

    public String getAide() {
        return aide;
    }

    public void setAide(String aide) {
        this.aide = aide;
    }

    public Boolean getEstactif() {
        return estactif;
    }

    public void setEstactif(Boolean estactif) {
        this.estactif = estactif;
    }

    public Boolean getEstverrouille() {
        return estverrouille;
    }

    public void setEstverrouille(Boolean estverrouille) {
        this.estverrouille = estverrouille;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public static QuestionBO mapQuestionEntityToBO(QuestionEntity questionEntity) {
        QuestionBO questionBO = new QuestionBO();
        questionBO.setId(questionEntity.getId());
        questionBO.setIntitule(questionEntity.getIntitule());
        questionBO.setAide(questionEntity.getAide());
        questionBO.setChoixreponse1(questionEntity.getChoixreponse1());
        questionBO.setChoixreponse2(questionEntity.getChoixreponse2());
        questionBO.setChoixreponse3(questionEntity.getChoixreponse3());
        questionBO.setChoixreponse4(questionEntity.getChoixreponse4());
        questionBO.setEstactif(questionEntity.getEstactif());
        questionBO.setEstverrouille(questionEntity.getEstverrouille());
        return questionBO;
    }

    public static QuestionEntity mapQuestionBOTOEntity(QuestionBO questionbo) {
        QuestionEntity myBoToEntity = new QuestionEntity();
        myBoToEntity.setId(questionbo.getId());
        myBoToEntity.setIntitule(questionbo.getIntitule());
        myBoToEntity.setAide(questionbo.getAide());
        myBoToEntity.setChoixreponse1(questionbo.getChoixreponse1());
        myBoToEntity.setChoixreponse2(questionbo.getChoixreponse2());
        myBoToEntity.setChoixreponse3(questionbo.getChoixreponse3());
        myBoToEntity.setChoixreponse4(questionbo.getChoixreponse4());
        myBoToEntity.setEstactif(questionbo.getEstactif());
        myBoToEntity.setEstverrouille(questionbo.getEstverrouille());
        return myBoToEntity;
    }
}