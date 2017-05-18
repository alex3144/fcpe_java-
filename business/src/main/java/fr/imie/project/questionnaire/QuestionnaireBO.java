package fr.imie.project.questionnaire;
import fr.imie.project.QuestionnaireEntity;


/**
 * Created by fred on 17/05/17.
 */
public class QuestionnaireBO {

    private int id;
    private String nom;
    private Boolean estactif;
    private Boolean estverrouille;

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static QuestionnaireBO mapQuestionnaireEntityToBO(QuestionnaireEntity questionnaireEntity) {
        QuestionnaireBO questionnaireBO = new QuestionnaireBO();
        questionnaireBO.setId(questionnaireEntity.getId());
        questionnaireBO.setNom(questionnaireEntity.getNom());
        questionnaireBO.setEstactif(questionnaireEntity.getEstactif());
        questionnaireBO.setEstverrouille(questionnaireEntity.getEstverrouille());
        return questionnaireBO;
    }

    public static QuestionnaireEntity mapQuestionnaireBOTOEntity(QuestionnaireBO questionnairebo) {
        QuestionnaireEntity myBoToEntity = new QuestionnaireEntity();
        myBoToEntity.setId(questionnairebo.getId());
        myBoToEntity.setNom(questionnairebo.getNom());
        myBoToEntity.setEstactif(questionnairebo.getEstactif());
        myBoToEntity.setEstverrouille(questionnairebo.getEstverrouille());
        return myBoToEntity;
    }
}
