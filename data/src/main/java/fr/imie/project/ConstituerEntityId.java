package fr.imie.project;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

/**
 * Created by fred on 19/05/17.
 */
public class ConstituerEntityId implements Serializable {

    private int id_questionnaire;
    private int id;


    public boolean equals(Object object) {
        if (object instanceof ConstituerEntityId) {
            ConstituerEntityId otherId = (ConstituerEntityId) object;
            return (otherId.id_questionnaire == this.id_questionnaire) && (otherId.id == this.id);
        }
        return false;
    }

}

