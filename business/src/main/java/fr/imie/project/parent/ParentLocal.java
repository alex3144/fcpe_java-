package fr.imie.project.parent;

import javafx.scene.Parent;

import java.util.List;
import javax.ejb.Local;

/**
 * Created by max on 29/05/2017.
 */
@Local
public interface ParentLocal {

    public List<ParentBO> DisplayEmails(Integer idclasse);

}
