package fr.imie.project.etablissement;
import fr.imie.project.EtablissementEntity;

/**
 * Created by fred on 17/05/17.
 */
public class EtablissementBO {
    private int id;
    private String nom;
    private String numrue;
    private String nomrue;
    private Integer cp;
    private String ville;
    private String departement;
    private String academie;
    private String typeetablissement;

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

    public String getNumrue() {
        return numrue;
    }

    public void setNumrue(String numrue) {
        this.numrue = numrue;
    }

    public String getNomrue() {
        return nomrue;
    }

    public void setNomrue(String nomrue) {
        this.nomrue = nomrue;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getAcademie() {
        return academie;
    }

    public void setAcademie(String academie) {
        this.academie = academie;
    }

    public String getTypeetablissement() {
        return typeetablissement;
    }

    public void setTypeetablissement(String typeetablissement) {
        this.typeetablissement = typeetablissement;
    }


    public static EtablissementBO mapEtablissementEntityToBO(EtablissementEntity etablissementEntity) {
        EtablissementBO etablissementBO = new EtablissementBO();
        etablissementBO.setId(etablissementEntity.getId());
        etablissementBO.setNom(etablissementEntity.getNom());
        etablissementBO.setNumrue(etablissementEntity.getNumrue());
        etablissementBO.setNomrue(etablissementEntity.getNomrue());
        etablissementBO.setAcademie(etablissementEntity.getAcademie());
        etablissementBO.setCp(etablissementEntity.getCp());
        etablissementBO.setDepartement(etablissementEntity.getDepartement());
        etablissementBO.setTypeetablissement(etablissementEntity.getTypeetablissement());
        return etablissementBO;
    }

    public static EtablissementEntity mapEtablissementBOTOEntity(EtablissementBO etablissementbo) {
        EtablissementEntity myBoToEntity = new EtablissementEntity();
        myBoToEntity.setId(etablissementbo.getId());
        myBoToEntity.setNom(etablissementbo.getNom());
        myBoToEntity.setNumrue(etablissementbo.getNumrue());
        myBoToEntity.setNomrue(etablissementbo.getNomrue());
        myBoToEntity.setAcademie(etablissementbo.getAcademie());
        myBoToEntity.setCp(etablissementbo.getCp());
        myBoToEntity.setDepartement(etablissementbo.getDepartement());
        myBoToEntity.setTypeetablissement(etablissementbo.getTypeetablissement());
        return myBoToEntity;
    }
}
