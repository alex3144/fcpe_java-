package fr.imie.project.emailSAAS;

import com.mailjet.client.MailjetClient;

/**
 * Created by max on 29/05/2017.
 */


public class mailjetAPI {

    MailjetClient client = new MailjetClient(System.getenv("c8dac4f06293b116e44b43653ef8f823"), System.getenv("c6873cb7acade767778ea21cb5c4d91f"));

}
