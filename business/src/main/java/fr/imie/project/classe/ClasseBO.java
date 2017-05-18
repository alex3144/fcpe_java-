package fr.imie.project.classe;
import fr.imie.project.ClasseEntity;
/**
 * Created by fred on 18/05/17.
 */
public class ClasseBO {

    private int id;
    private String nom;
    private String nomprenomprofprincipal;
    private String nomprenomparentdelegue;
    private String niveauclasse;
    private String serieclasse;

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

    public String getNomprenomprofprincipal() {
        return nomprenomprofprincipal;
    }

    public void setNomprenomprofprincipal(String nomprenomprofprincipal) {
        this.nomprenomprofprincipal = nomprenomprofprincipal;
    }

    public String getNomprenomparentdelegue() {
        return nomprenomparentdelegue;
    }

    public void setNomprenomparentdelegue(String nomprenomparentdelegue) {
        this.nomprenomparentdelegue = nomprenomparentdelegue;
    }

    public String getNiveauclasse() {
        return niveauclasse;
    }

    public void setNiveauclasse(String niveauclasse) {
        this.niveauclasse = niveauclasse;
    }

    public String getSerieclasse() {
        return serieclasse;
    }

    public void setSerieclasse(String serieclasse) {
        this.serieclasse = serieclasse;
    }
    public static ClasseBO mapClasseEntityToBO(ClasseEntity classeEntity) {
        ClasseBO classeBO = new ClasseBO();
        classeBO.setId(classeEntity.getId());
        classeBO.setNom(classeEntity.getNom());
        classeBO.setNomprenomprofprincipal(classeEntity.getNomprenomprofprincipal());
        classeBO.setNomprenomparentdelegue(classeEntity.getNomprenomparentdelegue());
        classeBO.setNiveauclasse(classeEntity.getNiveauclasse());
        classeBO.setSerieclasse(classeEntity.getSerieclasse());

        return classeBO;
    }

    public static ClasseEntity mapClasseBOTOEntity(ClasseBO classebo) {

        ClasseEntity myBoToEntity = new ClasseEntity();
        myBoToEntity.setId(classebo.getId());
        myBoToEntity.setNom(classebo.getNom());
        myBoToEntity.setNomprenomprofprincipal(classebo.getNomprenomprofprincipal());
        myBoToEntity.setNomprenomparentdelegue(classebo.getNomprenomparentdelegue());
        myBoToEntity.setNiveauclasse(classebo.getNiveauclasse());
        myBoToEntity.setSerieclasse(classebo.getSerieclasse());

        return myBoToEntity;
    }
}
