package fr.imie.project.campagne;

/**
 * Created by fred on 17/05/17.
 */

import fr.imie.project.CampagneEntity;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class CampagneEJB implements CampagneLocal {

    @PersistenceContext
    EntityManager em;

    public CampagneEJB() {
    }

    @Override
    public List<CampagneBO> findAll() {
        @SuppressWarnings("unchecked")
        List<CampagneEntity> campagnesEntity = em.createNamedQuery("Campagne.findAll", CampagneEntity.class).getResultList();
        List<CampagneBO> campagnesBO = new ArrayList<CampagneBO>();

        for(CampagneEntity campagneEntity : campagnesEntity){
            campagnesBO.add(CampagneBO.mapCampagneEntityToBO(campagneEntity));
        }
        return campagnesBO;
    }


    @Override
    public CampagneBO findOne(CampagneBO CampagneBO) {
        CampagneEntity entityC = (CampagneEntity) em.createNamedQuery("Campagne.findOne",  CampagneEntity.class).setParameter("id", CampagneBO.getId()).getSingleResult();
        CampagneBO finalC =  CampagneBO.mapCampagneEntityToBO(entityC);
        return finalC;
    }


    @Override
    public CampagneBO deleteCampagne(CampagneBO c) {
        CampagneEntity finalC = CampagneBO.mapCampagneBOTOEntity(c);
        CampagneEntity finalC2 =  em.merge(finalC);
        em.remove(finalC2);
        return c;
    }
    @Override
    public CampagneBO updateCampagne(CampagneBO c) {
        CampagneEntity finalC = CampagneBO.mapCampagneBOTOEntity(c);
        CampagneEntity finalC3 =  em.merge(finalC);
        return c;
    }

    @Override
    public void  createCampagne(CampagneBO c) {
        em.persist(CampagneBO.mapCampagneBOTOEntity(c));
    }

}