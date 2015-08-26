/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;

import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import juin2015.dto.ParametresDto;

/**
 *
 * @author Tritan
 */
public class MaJTParametres extends MaJTable<ParametresDto>{
   
    public MaJTParametres() throws MaJTableInitialisationException{
        
    }
    public MaJTParametres(Collection<ParametresDto> data)throws MaJTableInitialisationException{
        this();
        setData(data);
    }

    @Override
    protected void setTitres() {
        String []t ={ "nomSerie, nbEmetteurs, duree, delai, alea"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] m = {"getId, getNbEmetteurs, getDuree, getDelai, getAlea"};
        methodes = m;
    }

    @Override
    protected void setLargeurs() {
       int[]t={0,300,300,300,300};
       largeurs = t;
    }
}
