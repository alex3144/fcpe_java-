package fr.imie.project.classe;

import fr.imie.project.ClasseEntity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by fred on 18/05/17.
 */
public class ClasseEJB implements ClasseLocal {
    @PersistenceContext
    EntityManager em;

    public ClasseEJB() {
    }

    @Override
    public List<ClasseBO> findAll() {
        @SuppressWarnings("unchecked")
        List<ClasseEntity> classesEntity = em.createNamedQuery("Classe.findAll", ClasseEntity.class).getResultList();
        List<ClasseBO> classesBO = new ArrayList<ClasseBO>();

        for(ClasseEntity classeEntity : classesEntity){
            classesBO.add(ClasseBO.mapClasseEntityToBO(classeEntity));
        }
        return classesBO;
    }


    @Override
    public ClasseBO findOne(ClasseBO ClasseBO) {
        ClasseEntity entityC = (ClasseEntity) em.createNamedQuery("Classe.findOne",  ClasseEntity.class).setParameter("id", ClasseBO.getId()).getSingleResult();
        ClasseBO finalC =  ClasseBO.mapClasseEntityToBO(entityC);
        return finalC;
    }


    @Override
    public ClasseBO deleteClasse(ClasseBO c) {
        ClasseEntity finalC = ClasseBO.mapClasseBOTOEntity(c);
        ClasseEntity finalC2 =  em.merge(finalC);
        em.remove(finalC2);
        return c;
    }
    @Override
    public ClasseBO updateClasse(ClasseBO c) {
        ClasseEntity finalC = ClasseBO.mapClasseBOTOEntity(c);
        ClasseEntity finalC3 =  em.merge(finalC);
        return c;
    }

    @Override
    public void  createClasse(ClasseBO c) {
        em.persist(ClasseBO.mapClasseBOTOEntity(c));
    }
}
