/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.dto;

/****
 * Classe d'instanciation de critères de sélection de paramètres
 *
 *
 */
public class ParametresSel {
    private String debNom;
    private  int maxEmetteurs, minEmetteurs, minDuree, maxDuree;
    
    public ParametresSel(String debNom, int maxEmetteurs, int minEmetteurs, int minDuree, int maxDuree){
        this.debNom=debNom;
        this.maxEmetteurs=maxEmetteurs;
        this.minEmetteurs=minEmetteurs;
        this.minDuree=minDuree;
        this.maxDuree=maxDuree;
    }

    /**
     * @return the debNom
     */
    public String getDebNom() {
        return debNom;
    }

    /**
     * @return the maxEmetteurs
     */
    public int getMaxEmetteurs() {
        return maxEmetteurs;
    }

    /**
     * @return the minEmetteurs
     */
    public int getMinEmetteurs() {
        return minEmetteurs;
    }

    /**
     * @return the minDuree
     */
    public int getMinDuree() {
        return minDuree;
    }

    /**
     * @return the maxDuree
     */
    public int getMaxDuree() {
        return maxDuree;
    }
}
