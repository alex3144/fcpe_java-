package fr.imie.project;

import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.etablissement.EtablissementBO;
import fr.imie.project.etablissement.EtablissementLocal;
import fr.imie.project.classe.ClasseBO;

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
	public List<EtablissementBO> findAllEtablissement() {
		return etablissementLocal.findAllEtablissement();
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

	/*GESTION DES CAMPAGNES */

	@GET
	@Path("/{id}/campagnes")
	public List<CampagneBO> findAllCampagnes(@PathParam("id") Integer Idetablissement) {
		EtablissementBO etablissementBO = new EtablissementBO();
		etablissementBO.setId(Idetablissement);
		return etablissementLocal.findAllCampagnes(etablissementBO);
	}


	/*GESTION DES CLASSES */

	@GET
	@Path("/{idetab}/classes")
	public List<ClasseBO> findAllClasse(@PathParam("idetab") Integer Idetablissement) {
		return etablissementLocal.findAllClasse(Idetablissement);
	}

	@GET
	@Path("/{idetab}/classe/{idclasse}")
	public Response findOneClasse(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer idclasse) {
		ClasseBO finalBO = etablissementLocal.findOneClasse(Idetablissement, idclasse);
		return Response.ok(finalBO).build();
	}
	@POST
	@Path("/{idetab}/classe/create")
	public Response createClasse(@PathParam("idetab") Integer Idetab, ClasseBO classe){
		etablissementLocal.createClasse(Idetab, classe);
		return Response.ok(classe).build();
	}
	@DELETE
	@Path("/{idetab}/classe/{idclass}/delete")
	public Response deleteClasse(ClasseBO classe) {
		etablissementLocal.deleteClasse(classe);
		return Response.ok(classe).build();
	}
	@PUT
	@Path("/{idetab}/classe/{idclasse}/update")
	public Response updateClasse(@PathParam("idetab") Integer Idetab, @PathParam("idclasse") Integer idclasse) {
		etablissementLocal.updateClasse(Idetab, idclasse);
		return Response.ok(idclasse).build();
	}


}
