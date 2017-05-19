package fr.imie.project;

import javax.persistence.*;

/**
 * Created by fred on 19/05/17.
 */
@Entity
@Table(name = "_constituer", schema = "public", catalog = "fcpe")
@IdClass(ConstituerEntityId.class)
public class ConstituerEntity {
    @Id
    private int id; /*idquestion*/
    @Id
    private int id_questionnaire;
    @Column(name = "estobligatoire")
    private Boolean estobligatoire;
    @Column(name = "positionquestion")
    private int positionquestion;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private QuestionEntity question;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_questionnaire", referencedColumnName = "id")
    private QuestionnaireEntity questionnaire;
}


