package fr.imie.project.parent;
import fr.imie.project.ParentEntity;

/**
 * Created by max on 29/05/2017.
 */
public class ParentBO {
    private int id;
    private String nom;
    private String prenom;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public static ParentBO mapParentEntityToBO(ParentEntity parentEntity) {
        ParentBO parentBO = new ParentBO();
        parentBO.setEmail(parentEntity.getEmail());
        parentBO.setId((parentEntity.getId()));
        parentBO.setNom((parentEntity.getNom()));
        parentBO.setPrenom((parentEntity.getPrenom()));
        return parentBO;
    }



}
