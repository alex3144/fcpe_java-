package fr.imie.project;

import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.etablissement.EtablissementBO;
import fr.imie.project.etablissement.EtablissementLocal;
import fr.imie.project.classe.ClasseBO;
import fr.imie.project.question.QuestionBO;
import fr.imie.project.questionnaire.QuestionnaireBO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/etablissements")
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


	/*GERER CAMPAGNE ETABLISSEMENTS */
	@GET
	@Path("/{idetab}/classe/{idclasse}/campagnes")
	public List<CampagneBO> findAllClasse(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer Idclasse) {
		return etablissementLocal.findAllCampagnes(Idetablissement, Idclasse);
	}

	@GET
	@Path("/{idetab}/classe/{idclasse}/campagne/{idcampagne}")
	public CampagneBO findAllClasse(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer Idclasse, @PathParam("idcampagne") Integer idcampagne) {
		return etablissementLocal.findOneCampagnes(Idetablissement, Idclasse, idcampagne);
	}

	/*GERER QUESTIONNAIRE D'UNE CAMPAGNE D'UNE CLASSE D'UN ETABLISSEMENT */

	@GET
	@Path("/{idetab}/classe/{idclasse}/campagne/{idcampagne}/questionnaire")
	public QuestionnaireBO findQuestionnaire(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer Idclasse, @PathParam("idcampagne") Integer idcampagne) {
		return etablissementLocal.findQuestionnaire(Idetablissement, Idclasse, idcampagne);
	}

	/*GERER QUESTION D'UN QUESTIONNAIRE D'UNE CAMPAGNE D'UNE CLASSE D'UN ETABLISSEMENT */

	@GET
	@Path("/{idetab}/classe/{idclasse}/campagne/{idcampagne}/questionnaire/questions")
	public List<QuestionBO> findAllQuestion(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer Idclasse, @PathParam("idcampagne") Integer idcampagne) {
		return etablissementLocal.findAllQuestion(Idetablissement, Idclasse, idcampagne);
	}

	@GET
	@Path("/{idetab}/classe/{idclasse}/campagne/{idcampagne}/questionnaire/question/{idquest}")
	public QuestionBO findOneQuestion(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer Idclasse, @PathParam("idcampagne") Integer idcampagne, @PathParam("idquest") Integer idquestion) {
		return etablissementLocal.findOneQuestion(Idetablissement, Idclasse, idcampagne, idquestion);
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
	@Path("/{idetab}/classe/{idclasse}/delete")
	public Response deleteClasse(@PathParam("idetab") Integer Idetablissement, @PathParam("idclasse") Integer idclasse) {
		etablissementLocal.deleteClasse(Idetablissement, idclasse);
		return Response.ok(Idetablissement).build();
	}
	@PUT
	@Path("/{idetab}/classe/{idclasse}/update")
	public Response updateClasse(@PathParam("idetab") Integer Idetab, @PathParam("idclasse") Integer idclasse) {
		etablissementLocal.updateClasse(Idetab, idclasse);
		return Response.ok(idclasse).build();
	}





}
