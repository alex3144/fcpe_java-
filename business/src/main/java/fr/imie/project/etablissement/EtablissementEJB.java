package fr.imie.project.etablissement;

/**
 * Created by fred on 17/05/17.
 */

import fr.imie.project.EtablissementEntity;
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
    public List<EtablissementBO> findAll() {
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

}