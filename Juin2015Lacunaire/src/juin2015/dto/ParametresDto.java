/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juin2015.dto;

import be.esi.alg2.dto.Dto;

/**
 * Dto d'instanciation d'un paramètre
 */
public class ParametresDto extends Dto<String> {


    private int nbEmetteurs, duree, delai, alea;




     public ParametresDto( String nomSerie, int nbEmetteurs, int duree, int delai, int alea){
        this.id = nomSerie;
        this.nbEmetteurs=nbEmetteurs;
        this.duree=duree;
        this.delai=delai;
        this.alea=alea;
    }



   @Override
    public String toString(){
        String res="[Parametres]: ";

        res += (getId() != null ) ? "(" + getId() + ")" : "(**)";
        res += "  " + getNbEmetteurs();

        return res;
    }

    /**
     * @return the nbEmetteurs
     */
    public int getNbEmetteurs() {
        return nbEmetteurs;
    }

    /**
     * @param nbEmetteurs the nbEmetteurs to set
     */
    public void setNbEmetteurs(int nbEmetteurs) {
        this.nbEmetteurs = nbEmetteurs;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the delai
     */
    public int getDelai() {
        return delai;
    }

    /**
     * @param delai the delai to set
     */
    public void setDelai(int delai) {
        this.delai = delai;
    }

    /**
     * @return the alea
     */
    public int getAlea() {
        return alea;
    }

    /**
     * @param alea the alea to set
     */
    public void setAlea(int alea) {
        this.alea = alea;
    }

}
