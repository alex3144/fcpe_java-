package fr.imie.project.campagne;

import fr.imie.project.campagne.CampagneBO;

import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
public interface CampagneLocal {
    public List<CampagneBO> findAll();
    public CampagneBO findOne(CampagneBO campagne);
    public void createCampagne(CampagneBO campagne);
    public CampagneBO deleteCampagne(CampagneBO campagne);
    public CampagneBO updateCampagne(CampagneBO campagne);
}
