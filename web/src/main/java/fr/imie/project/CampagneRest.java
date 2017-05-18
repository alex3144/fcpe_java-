package fr.imie.project;

import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.campagne.CampagneLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/campagnes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CampagneRest {

	@EJB
	private CampagneLocal campagneLocal;

	@GET
	public List<CampagneBO> findAll() {
		return campagneLocal.findAll();
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Integer Idcampagne) {
		CampagneBO campagneBO = new CampagneBO();
		campagneBO.setId(Idcampagne);
		CampagneBO finalBO = campagneLocal.findOne(campagneBO);
		return Response.ok(finalBO).build();
	}
	@POST
	@Path("create")
	public Response createCampagne(CampagneBO campagne){
		campagneLocal.createCampagne(campagne);
		return Response.ok(campagne).build();
	}
	@DELETE
	@Path("delete")
	public Response deleteCampagne(CampagneBO campagne) {
		campagneLocal.deleteCampagne(campagne);
		return Response.ok(campagne).build();
	}
	@PUT
	@Path("update")
	public Response updateCampagne(CampagneBO campagne) {
		campagneLocal.updateCampagne(campagne);
		return Response.ok(campagne).build();
	}


}
