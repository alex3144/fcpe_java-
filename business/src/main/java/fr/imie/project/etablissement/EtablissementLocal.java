package fr.imie.project.etablissement;
import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.classe.ClasseBO;
import fr.imie.project.question.QuestionBO;
import fr.imie.project.questionnaire.QuestionnaireBO;

import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
public interface EtablissementLocal {
    public List<EtablissementBO> findAllEtablissement();

    public EtablissementBO findOne(EtablissementBO etablissement);

    public void createEtablissement(EtablissementBO etablissement);

    public List<QuestionBO> findAllQuestionsEtab(Integer Idetablissement);

    public EtablissementBO deleteEtablissement(EtablissementBO etablissement);

    public EtablissementBO updateEtablissement(EtablissementBO etablissement);

    /* GESTION DES CAMPAGNES */

    public List<CampagneBO> findAllCampagnes(Integer Idetablissement, Integer idclasse);

    public  CampagneBO findOneCampagnes(Integer Idetablissement, Integer idclasse, Integer idcampagne);

    /*GERE QUESTIONNAIRE D'UNE CAMPAGNE D'UNE CLASSE D'UN ETABLISSEMENT */

    public QuestionnaireBO findQuestionnaire(Integer Idetablissement, Integer idclasse, Integer idcampagne);

    /*GERER QUESTION D'UN QUESTIONNAIRE D'UNE CAMPAGNE D'UNE CLASSE D'UN ETABLISSEMENT */

    public List<QuestionBO> findAllQuestion(Integer Idetablissement, Integer idclasse, Integer idcampagne);

    public QuestionBO findOneQuestion(Integer Idetablissement, Integer idclasse, Integer idcampagne, Integer idquestion);

    /* GESTION DES CLASSES */

    public List<ClasseBO> findAllClasse(Integer Idetablissement);

    public ClasseBO findOneClasse(Integer Idetablissement, Integer idclasse);

    public void createClasse(Integer Idetablissement, ClasseBO classe);

    public void deleteClasse(Integer Idetablissement, Integer idclasse);

    public ClasseBO updateClasse(Integer Idetablissement, Integer idclasse);

}

