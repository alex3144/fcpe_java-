package fr.imie.project.question;

import fr.imie.project.question.QuestionBO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface QuestionLocal {

	public List<QuestionBO> findAll();
	public QuestionBO findOne(QuestionBO question);
	public void createQuestion(QuestionBO question);
	public QuestionBO deleteQuestion(QuestionBO question);
	public QuestionBO updateQuestion(QuestionBO question);


}