package fr.imie.project.parent;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import fr.imie.project.campagne.CampagneBO;
import javafx.scene.Parent;

import java.util.List;
import javax.ejb.Local;

/**
 * Created by max on 29/05/2017.
 */
@Local
public interface ParentLocal {

    public CampagneBO DisplayEmails(Integer idclasse, Integer idcampagne) throws MailjetSocketTimeoutException, MailjetException;

}
