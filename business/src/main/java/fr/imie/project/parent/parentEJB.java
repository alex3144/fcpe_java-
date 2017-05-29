package fr.imie.project.parent;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import fr.imie.project.CampagneEntity;
import fr.imie.project.ParentEntity;
import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.emailSAAS.mailjetAPI;
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
    public CampagneBO DisplayEmails(Integer idclasse, Integer idcampagne) throws MailjetSocketTimeoutException, MailjetException {

        /* TRAITEMENT DES PARAMETRES */

        List<ParentEntity> parents = (List<ParentEntity>) em.createNamedQuery("Parent.findEmails", ParentEntity.class).setParameter("idClass", idclasse).getResultList();
         CampagneEntity campagneEntity = em.createNamedQuery("Campagne.findOne" , CampagneEntity.class).setParameter("id", idcampagne).getSingleResult();

         CampagneBO campagneBO = CampagneBO.mapCampagneEntityToBO(campagneEntity);
         List<ParentBO> parentBOs = new ArrayList<ParentBO>();

        for(ParentEntity parentEntity : parents){
            parentBOs.add(ParentBO.mapParentEntityToBO(parentEntity));
        }

        /* ENVOYER DES MAILS */

        mailjetAPI myMail = new mailjetAPI();
        myMail.sendMail(parentBOs, campagneBO);

        return campagneBO;

    }
}
