package fr.imie.project;

/**
 * Created by max on 29/05/2017.
 */

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
    @Path("/{id}/parents")
    public Response DisplayEmails(@PathParam("id") Integer idClasse) {
        List<ParentBO> parentsBo = parentLocal.DisplayEmails(idClasse);
        return Response.ok(parentsBo).build();
    }

}
