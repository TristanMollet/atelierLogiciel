/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;

import be.esi.alg2.ebiblio.gui.outils.MaJTable;
import be.esi.alg2.ebiblio.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import javax.swing.JFrame;
import juin2015.db.ParametresDB;
import juin2015.dto.ParametresDto;
import juin2015.dto.ParametresSel;

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
        String []t ={ "nomSerie", "nbEmetteurs", "duree", "delai", "alea"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] m = {"getId","getNbEmetteurs", "getDuree", "getDelai", "getAlea"};
        methodes = m;
    }

    @Override
    protected void setLargeurs() {
       int[]t={100,100,100,100,100};
       largeurs = t;
    }

    @Override
    public ParametresDto getSelectedObject() {
        return super.getSelectedObject(); //To change body of generated methods, choose Tools | Templates.
    }
    

}