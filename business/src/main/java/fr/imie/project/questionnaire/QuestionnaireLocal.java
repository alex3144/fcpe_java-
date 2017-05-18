package fr.imie.project.questionnaire;

import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
public interface QuestionnaireLocal {
    public List<QuestionnaireBO> findAll();
    public QuestionnaireBO findOne(QuestionnaireBO questionnaire);
    public void createQuestionnaire(QuestionnaireBO questionnaire);
    public QuestionnaireBO deleteQuestionnaire(QuestionnaireBO questionnaire);
    public QuestionnaireBO updateQuestionnaire(QuestionnaireBO questionnaire);
}
