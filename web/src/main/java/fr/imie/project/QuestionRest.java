package fr.imie.project;

import fr.imie.project.question.QuestionBO;
import fr.imie.project.question.QuestionLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/questions")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionRest {

	@EJB
	private QuestionLocal questionLocal;

	@GET
	public List<QuestionBO> findAll() {
		return questionLocal.findAll();
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Integer Idquestion) {
		QuestionBO questionBO = new QuestionBO();
		questionBO.setId(Idquestion);
		QuestionBO finalBO = questionLocal.findOne(questionBO);
		return Response.ok(finalBO).build();
	}
	@POST
	@Path("create")
	public Response createQuestion(QuestionBO question){
		questionLocal.createQuestion(question);
		return Response.ok(question).build();
	}
	@DELETE
	@Path("delete")
	public Response deleteQuestion(QuestionBO question) {
		questionLocal.deleteQuestion(question);
		return Response.ok(question).build();
	}
	@PUT
	@Path("update")
	public Response updateQuestion(QuestionBO question) {
		questionLocal.updateQuestion(question);
		return Response.ok(question).build();
	}


}
