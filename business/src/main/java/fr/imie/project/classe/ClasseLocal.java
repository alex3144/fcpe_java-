package fr.imie.project.classe;

import java.util.List;
import fr.imie.project.classe.ClasseBO;

/**
 * Created by fred on 18/05/17.
 */
public interface ClasseLocal {

    public List<ClasseBO> findAll();
    public ClasseBO findOne(ClasseBO classe);
    public void createClasse(ClasseBO classe);
    public ClasseBO deleteClasse(ClasseBO classe);
    public ClasseBO updateClasse(ClasseBO classe);
}


