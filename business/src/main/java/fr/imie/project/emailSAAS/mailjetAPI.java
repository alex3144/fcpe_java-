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
import fr.imie.project.parent.ParentBO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by max on 29/05/2017.
 */


public class mailjetAPI {

        public static void sendMail(List<ParentBO> contacts, CampagneBO camp) throws MailjetException, MailjetSocketTimeoutException {
            MailjetClient client;
            client = new MailjetClient("c8dac4f06293b116e44b43653ef8f823", "c6873cb7acade767778ea21cb5c4d91f");
            MailjetResponse response;
            MailjetRequest request;
            JSONArray recipients = new JSONArray();

            for (ParentBO parentBO : contacts){
                recipients.put(new JSONObject().put(Contact.EMAIL, parentBO.getEmail()));
            }

            request = new MailjetRequest(Email.resource)
                    .property(Email.RECIPIENTS, recipients)
                    .property(Email.FROMEMAIL, "alexboceno@hotmail.fr")
                    .property(Email.FROMNAME, "Votre etablissement")
                    .property(Email.SUBJECT, "Campagne trimestriel")
                    .property(Email.TEXTPART, "Voici votre questionnaire trimestriel en lien ci dessous" + " " + camp.getUrlcollective());

            response = client.post(request);
            System.out.println(response.getData());
        }

};

