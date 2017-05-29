package fr.imie.project.emailSAAS;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Contact;
import com.mailjet.client.resource.Email;
import fr.imie.project.ParentEntity;
import fr.imie.project.campagne.CampagneBO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by max on 29/05/2017.
 */


public class mailjetAPI {

    MailjetClient client = new MailjetClient(System.getenv("c8dac4f06293b116e44b43653ef8f823"), System.getenv("c6873cb7acade767778ea21cb5c4d91f"));
    MailjetRequest contacts;
    MailjetRequest email;
    JSONArray recipients;
    MailjetResponse response;

    public void sendMail(List<ParentEntity> contacts, CampagneBO camp) throws MailjetSocketTimeoutException, MailjetException {


        recipients = new JSONArray()
                .put(new JSONObject().put(Contact.EMAIL, "roger@mailjet.com"))
                .put(new JSONObject().put(Contact.EMAIL, "stan@mailjet.com"))
                .put(new JSONObject().put(Contact.EMAIL, "francine@mailjet.com"));

        email = new MailjetRequest(Email.resource)
                .property(Email.FROMNAME, "Votre Etablissement scolaire")
                .property(Email.FROMEMAIL, "campagneFCPE@noreply.fr")
                .property(Email.SUBJECT, "Voici votre questionnaire trimestriel en lien ci dessous" + camp.getUrlcollective())
                .property(Email.RECIPIENTS, recipients)
                .property(Email.MJCUSTOMID, "fcpe");

        response = client.post(email);
    }


}
