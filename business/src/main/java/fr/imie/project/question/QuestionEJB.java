package fr.imie.project.question;

import fr.imie.project.QuestionEntity;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QuestionEJB implements QuestionLocal {

    @PersistenceContext
    EntityManager em;

    public QuestionEJB() {
    }

    @Override
    public List<QuestionBO> findAll() {
        @SuppressWarnings("unchecked")
        List<QuestionEntity> questionsEntity = em.createNamedQuery("Question.findAll", QuestionEntity.class).getResultList();
        List<QuestionBO> questionsBO = new ArrayList<QuestionBO>();

        for(QuestionEntity questionEntity : questionsEntity){
            questionsBO.add(QuestionBO.mapQuestionEntityToBO(questionEntity));
        }
        return questionsBO;
    }


    @Override
    public QuestionBO findOne(QuestionBO QuestionBO) {
        QuestionEntity entityQ = (QuestionEntity) em.createNamedQuery("Question.findOne",  QuestionEntity.class).setParameter("id", QuestionBO.getId()).getSingleResult();
        QuestionBO finalQ =  QuestionBO.mapQuestionEntityToBO(entityQ);
        return finalQ;
    }


   @Override
    public QuestionBO deleteQuestion(QuestionBO q) {
        QuestionEntity finalQ = QuestionBO.mapQuestionBOTOEntity(q);
        QuestionEntity finalQ2 =  em.merge(finalQ);
        em.remove(finalQ2);
        return q;
    }
    @Override
    public QuestionBO updateQuestion(QuestionBO q) {
        QuestionEntity finalQ = QuestionBO.mapQuestionBOTOEntity(q);
        QuestionEntity finalQ3 =  em.merge(finalQ);
        return q;
    }

    @Override
    public void  createQuestion(QuestionBO q) {
        em.persist(QuestionBO.mapQuestionBOTOEntity(q));
    }

}