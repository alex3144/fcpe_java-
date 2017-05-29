package fr.imie.project.parent;

import fr.imie.project.ParentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 29/05/2017.
 */
@Stateless
public class parentEJB implements ParentLocal {

    @PersistenceContext
    EntityManager em;


    @Override
    public List<ParentBO> DisplayEmails(Integer idclasse){
         List<ParentEntity> parents = (List<ParentEntity>) em.createNamedQuery("Parent.findEmails", ParentEntity.class).setParameter("idClass", idclasse).getResultList();
         List<ParentBO> parentBOs = new ArrayList<ParentBO>();

        for(ParentEntity parentEntity : parents){
            parentBOs.add(ParentBO.mapParentEntityToBO(parentEntity));
        }

        return  parentBOs;

    }
}
