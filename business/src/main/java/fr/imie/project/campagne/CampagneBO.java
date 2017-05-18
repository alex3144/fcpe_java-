package fr.imie.project.campagne;
import fr.imie.project.CampagneEntity;

import java.util.Date;

/**
 * Created by fred on 17/05/17.
 */
public class CampagneBO {
    private int id;
    private String nom;
    private Date datefin;
    private String nomconsclasse;
    private String trimconsclasse;
    private Date dateconsclasse;
    private String statut;
    private String urlcollective;

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

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getNomconsclasse() {
        return nomconsclasse;
    }

    public void setNomconsclasse(String nomconsclasse) {
        this.nomconsclasse = nomconsclasse;
    }

    public String getTrimconsclasse() {
        return trimconsclasse;
    }

    public void setTrimconsclasse(String trimconsclasse) {
        this.trimconsclasse = trimconsclasse;
    }

    public Date getDateconsclasse() {
        return dateconsclasse;
    }

    public void setDateconsclasse(Date dateconsclasse) {
        this.dateconsclasse = dateconsclasse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getUrlcollective() {
        return urlcollective;
    }

    public void setUrlcollective(String urlcollective) {
        this.urlcollective = urlcollective;
    }

    public static CampagneBO mapCampagneEntityToBO(CampagneEntity campagneEntity) {

        CampagneBO campagneBO = new CampagneBO();
        campagneBO.setId(campagneEntity.getId());
        campagneBO.setNom(campagneEntity.getNom());
        campagneBO.setDateconsclasse(campagneEntity.getDateconsclasse());
        campagneBO.setDatefin(campagneEntity.getDatefin());
        campagneBO.setNomconsclasse(campagneEntity.getNomconsclasse());
        campagneBO.setStatut(campagneEntity.getStatut());
        campagneBO.setTrimconsclasse(campagneEntity.getTrimconsclasse());
        campagneBO.setUrlcollective(campagneEntity.getUrlcollective());
        return campagneBO;
    }

    public static CampagneEntity mapCampagneBOTOEntity(CampagneBO campagnebo) {
        CampagneEntity myBoToEntity = new CampagneEntity();
        myBoToEntity.setId(campagnebo.getId());
        myBoToEntity.setNom(campagnebo.getNom());
        myBoToEntity.setDateconsclasse((java.sql.Date) campagnebo.getDateconsclasse());
        myBoToEntity.setDatefin((java.sql.Date) campagnebo.getDatefin());
        myBoToEntity.setNomconsclasse(campagnebo.getNomconsclasse());
        myBoToEntity.setStatut(campagnebo.getStatut());
        myBoToEntity.setTrimconsclasse(campagnebo.getTrimconsclasse());
        myBoToEntity.setUrlcollective(campagnebo.getUrlcollective());
        return myBoToEntity;
    }
}
