package fr.imie.project;

import fr.imie.project.etablissement.EtablissementBO;
import fr.imie.project.etablissement.EtablissementLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/etablissements")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EtablissementRest {

	@EJB
	private EtablissementLocal etablissementLocal;

	@GET
	public List<EtablissementBO> findAll() {
		return etablissementLocal.findAll();
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Integer Idetablissement) {
		EtablissementBO etablissementBO = new EtablissementBO();
		etablissementBO.setId(Idetablissement);
		EtablissementBO finalBO = etablissementLocal.findOne(etablissementBO);
		return Response.ok(finalBO).build();
	}
	@POST
	@Path("create")
	public Response createEtablissement(EtablissementBO etablissement){
		etablissementLocal.createEtablissement(etablissement);
		return Response.ok(etablissement).build();
	}
	@DELETE
	@Path("delete")
	public Response deleteEtablissement(EtablissementBO etablissement) {
		etablissementLocal.deleteEtablissement(etablissement);
		return Response.ok(etablissement).build();
	}
	@PUT
	@Path("update")
	public Response updateEtablissement(EtablissementBO etablissement) {
		etablissementLocal.updateEtablissement(etablissement);
		return Response.ok(etablissement).build();
	}


}
