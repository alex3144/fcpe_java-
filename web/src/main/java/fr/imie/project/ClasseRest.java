package fr.imie.project;

/**
 * Created by max on 29/05/2017.
 */

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.parent.ParentBO;
import fr.imie.project.parent.ParentLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/classe")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ClasseRest {

    @EJB
    private ParentLocal parentLocal;

    @GET
    @Path("/{id}/campagnesmailling/{idcampagne}")
    public Response DisplayEmails(@PathParam("id") Integer idClasse, @PathParam("idcampagne") Integer idcampagne) throws MailjetSocketTimeoutException, MailjetException {
        CampagneBO parentsBo = parentLocal.DisplayEmails(idClasse, idcampagne);
        if (parentsBo == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok("Votre campagne" + " " + parentsBo.getNom() + " " + "a ete lancee" ).build();
    }

}
