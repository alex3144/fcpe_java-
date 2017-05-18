package fr.imie.project.etablissement;

import java.util.List;

/**
 * Created by fred on 17/05/17.
 */
public interface EtablissementLocal {
    public List<EtablissementBO> findAll();
    public EtablissementBO findOne(EtablissementBO etablissement);
    public void createEtablissement(EtablissementBO etablissement);
    public EtablissementBO deleteEtablissement(EtablissementBO etablissement);
    public EtablissementBO updateEtablissement(EtablissementBO etablissement);
}
