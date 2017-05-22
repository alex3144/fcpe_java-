package fr.imie.project.etablissement;
import fr.imie.project.campagne.CampagneBO;
import fr.imie.project.classe.ClasseBO;

import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
public interface EtablissementLocal {
    public List<EtablissementBO> findAllEtablissement();

    public EtablissementBO findOne(EtablissementBO etablissement);

    public void createEtablissement(EtablissementBO etablissement);

    public EtablissementBO deleteEtablissement(EtablissementBO etablissement);

    public EtablissementBO updateEtablissement(EtablissementBO etablissement);

    /* GESTION DES CAMPAGNES */

    public List<CampagneBO> findAllCampagnes(EtablissementBO etablissement);

    /* GESTION DES CLASSES */

    public List<ClasseBO> findAllClasse(Integer Idetablissement);

    public ClasseBO findOneClasse(Integer Idetablissement, Integer idclasse);

    public void createClasse(Integer Idetablissement, ClasseBO classe);

    public ClasseBO deleteClasse(ClasseBO classe);

    public ClasseBO updateClasse(Integer Idetablissement, Integer idclasse);

}

