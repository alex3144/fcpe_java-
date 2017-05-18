package fr.imie.project;

import fr.imie.project.questionnaire.QuestionnaireBO;
import fr.imie.project.questionnaire.QuestionnaireLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/questionnaires")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionnaireRest {

	@EJB
	private QuestionnaireLocal questionnaireLocal;

	@GET
	public List<QuestionnaireBO> findAll() {
		return questionnaireLocal.findAll();
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Integer Idquestionnaire) {
		QuestionnaireBO questionnaireBO = new QuestionnaireBO();
		questionnaireBO.setId(Idquestionnaire);
		QuestionnaireBO finalBO = questionnaireLocal.findOne(questionnaireBO);
		return Response.ok(finalBO).build();
	}
	@POST
	@Path("create")
	public Response createQuestionnaire(QuestionnaireBO questionnaire){
		questionnaireLocal.createQuestionnaire(questionnaire);
		return Response.ok(questionnaire).build();
	}
	@DELETE
	@Path("delete")
	public Response deleteQuestionnaire(QuestionnaireBO questionnaire) {
		questionnaireLocal.deleteQuestionnaire(questionnaire);
		return Response.ok(questionnaire).build();
	}
	@PUT
	@Path("update")
	public Response updateQuestionnaire(QuestionnaireBO questionnaire) {
		questionnaireLocal.updateQuestionnaire(questionnaire);
		return Response.ok(questionnaire).build();
	}


}
