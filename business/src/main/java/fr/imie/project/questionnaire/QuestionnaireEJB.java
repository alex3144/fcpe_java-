

/**
 * Created by fred on 17/05/17.
 */

package fr.imie.project.questionnaire;

        import fr.imie.project.QuestionnaireEntity;

        import java.util.ArrayList;
        import java.util.List;
        import javax.ejb.Stateless;
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;

@Stateless
public class QuestionnaireEJB implements QuestionnaireLocal {

    @PersistenceContext
    EntityManager em;

    public QuestionnaireEJB() {
    }

    @Override
    public List<QuestionnaireBO> findAll() {
        @SuppressWarnings("unchecked")
        List<QuestionnaireEntity> questionnairesEntity = em.createNamedQuery("Questionnaire.findAll", QuestionnaireEntity.class).getResultList();
        List<QuestionnaireBO> questionnairesBO = new ArrayList<QuestionnaireBO>();

        for(QuestionnaireEntity questionEntity : questionnairesEntity){
            questionnairesBO.add(QuestionnaireBO.mapQuestionnaireEntityToBO(questionEntity));
        }
        return questionnairesBO;
    }


    @Override
    public QuestionnaireBO findOne(QuestionnaireBO QuestionnaireBO) {
        QuestionnaireEntity entityQ = (QuestionnaireEntity) em.createNamedQuery("Questionnaire.findOne",  QuestionnaireEntity.class).setParameter("id", QuestionnaireBO.getId()).getSingleResult();
        QuestionnaireBO finalQ =  QuestionnaireBO.mapQuestionnaireEntityToBO(entityQ);
        return finalQ;
    }


    @Override
    public QuestionnaireBO deleteQuestionnaire(QuestionnaireBO q) {
        QuestionnaireEntity finalQ = QuestionnaireBO.mapQuestionnaireBOTOEntity(q);
        QuestionnaireEntity finalQ2 =  em.merge(finalQ);
        em.remove(finalQ2);
        return q;
    }
    @Override
    public QuestionnaireBO updateQuestionnaire(QuestionnaireBO q) {
        QuestionnaireEntity finalQ = QuestionnaireBO.mapQuestionnaireBOTOEntity(q);
        QuestionnaireEntity finalQ3 =  em.merge(finalQ);
        return q;
    }

    @Override
    public void  createQuestionnaire(QuestionnaireBO q) {
        em.persist(QuestionnaireBO.mapQuestionnaireBOTOEntity(q));
    }

}