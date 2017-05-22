package fr.imie.project.etablissement;

/**
 * Created by fred on 17/05/17.
 */

import fr.imie.project.CampagneEntity;
import fr.imie.project.ClasseEntity;
import fr.imie.project.EtablissementEntity;
import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.classe.ClasseBO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class EtablissementEJB implements EtablissementLocal {

    @PersistenceContext
    EntityManager em;

    public EtablissementEJB() {
    }

    @Override
    public List<EtablissementBO> findAllEtablissement() {
        @SuppressWarnings("unchecked")
        List<EtablissementEntity> etablissementsEntity = em.createNamedQuery("Etablissement.findAll", EtablissementEntity.class).getResultList();
        List<EtablissementBO> etablissementsBO = new ArrayList<EtablissementBO>();

        for(EtablissementEntity etablissementEntity : etablissementsEntity){
            etablissementsBO.add(EtablissementBO.mapEtablissementEntityToBO(etablissementEntity));
        }
        return etablissementsBO;
    }


    @Override
    public EtablissementBO findOne(EtablissementBO EtablissementBO) {
        EtablissementEntity entityE = (EtablissementEntity) em.createNamedQuery("Etablissement.findOne",  EtablissementEntity.class).setParameter("id", EtablissementBO.getId()).getSingleResult();
        EtablissementBO finalE =  EtablissementBO.mapEtablissementEntityToBO(entityE);
        return finalE;
    }


    @Override
    public EtablissementBO deleteEtablissement(EtablissementBO e) {
        EtablissementEntity finalE = EtablissementBO.mapEtablissementBOTOEntity(e);
        EtablissementEntity finalE2 =  em.merge(finalE);
        em.remove(finalE2);
        return e;
    }
    @Override
    public EtablissementBO updateEtablissement(EtablissementBO e) {
        EtablissementEntity finalE = EtablissementBO.mapEtablissementBOTOEntity(e);
        EtablissementEntity finalE3 =  em.merge(finalE);
        return e;
    }



    @Override
    public void  createEtablissement(EtablissementBO e) {
        em.persist(EtablissementBO.mapEtablissementBOTOEntity(e));
    }

    /*GESTION DES CAMPAGNES */

    @Override
    public List<CampagneBO> findAllCampagnes(EtablissementBO e) {
        List<CampagneEntity> campagneEntity = em.createNamedQuery("Etablissement.findAllCampagnes", CampagneEntity.class).setParameter("id", e.getId()).getResultList();
        List<CampagneBO> campagnesBO = new ArrayList<CampagneBO>();

        return campagnesBO;
    }

    /*GESTION DES CLASSES */

    @Override
    public List<ClasseBO> findAllClasse(Integer Idetablissement) {
        @SuppressWarnings("unchecked")
        List<ClasseEntity> classesEntity = em.createNamedQuery("Classe.findAllClasse", ClasseEntity.class).setParameter("id", Idetablissement).getResultList();
        List<ClasseBO> classesBO = new ArrayList<ClasseBO>();

        for(ClasseEntity classeEntity : classesEntity){
            classesBO.add(ClasseBO.mapClasseEntityToBO(classeEntity));
        }
        return classesBO;
    }


    @Override
    public ClasseBO findOneClasse(Integer Idetablissement, Integer ClasseId) {
        ClasseEntity entityC = (ClasseEntity) em.createNamedQuery("Classe.findOneClasse",  ClasseEntity.class).setParameter("idEtab", Idetablissement).setParameter("idClasse", ClasseId).getSingleResult();
        ClasseBO finalC =  ClasseBO.mapClasseEntityToBO(entityC);
        return finalC;
    }


    @Override
    public ClasseBO deleteClasse(ClasseBO classe) {
        if(classe != null) {
            ClasseEntity finalC = ClasseBO.mapClasseBOTOEntity(classe);
            ClasseEntity finalC2 = em.merge(finalC);
            em.remove(finalC2);
            return classe;
        }else{
            return classe;
        }
    }
    @Override
    public ClasseBO updateClasse(Integer Idetablissement, Integer ClasseId) {
        ClasseBO c = new ClasseBO();
        c.setId(ClasseId);
        ClasseEntity finalC = ClasseBO.mapClasseBOTOEntity(c);
        ClasseEntity finalC3 =  em.merge(finalC);
        return c;
    }

    @Override
    public void  createClasse(Integer Idetablissement,  ClasseBO c) {
        em.persist(ClasseBO.mapClasseBOTOEntity(c));
    }

}
