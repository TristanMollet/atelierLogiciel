/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.architecturemvc;

import java.util.Date;

/**
 *
 * Dto de l'état du modèle  
 */
public class EtatEmissions {
   private int nbEmetteurs;
   private int[] nbEmissions;
   private int[] sommeIntensite;
   private double[] moyenneIntensite;
   private double moyenneIntensiteTotal;
   private int nbEmissionTotal,  sommeIntensitéTotal;
   private Date momentPremEmission, momentDerEmission;
   private boolean actif;
   private int derEmetteur;
   
   public EtatEmissions(int nbEmetteurs,int[] nbEmissions,int[] sommeIntensite,double[] moyenneIntensite, boolean actif, int derEmetteur,
           int nbEmissionTotal, double moyenneIntensiteTotal,int sommeIntensitéTotal ){
       this.sommeIntensitéTotal=sommeIntensitéTotal;
       this.moyenneIntensiteTotal=moyenneIntensiteTotal;
       this.nbEmissionTotal=nbEmissionTotal;
       this.nbEmetteurs=nbEmetteurs;
       this.nbEmissions=nbEmissions;
       this.sommeIntensite=sommeIntensite;
       this.actif=actif;
       this.moyenneIntensite=moyenneIntensite;
       this.derEmetteur=derEmetteur;
       
   }

    /**
     * nombre d'émetteurs
     * @return le nombre d'émetteurs
     */
    public int getNbEmetteurs() {
        return nbEmetteurs;
    }

    /**
     * nombre total d'émissions
     * @return le nombre d'émissions
     */
    public int[] getNbEmissions() {
        return nbEmissions;
    }

    /**
     * somme des intensités émises
     * @return la somme des intensités émises
     */
    public int[] getSommeIntensite() {
        return sommeIntensite;
    }

    /**
     * moyenne des intensités émises
     * @return la moyenne des intensités émises
     */
    public double[] getMoyenneIntensite() {
        return moyenneIntensite;
    }

    /**
     * nombre total d'émissions
     * @return le nombre total d'émissions
     */
    public int getNbEmissionTotal() {
        return nbEmissionTotal;
    }

    /**
     * moyenne des intensités sur l'ensemble des intensités
     * @return la moyenne des intensités sur l'ensemble des émissions
     */
    public double getMoyenneIntensiteTotal() {
        return moyenneIntensiteTotal;
    }

    /**
     * somme de toutes les intensités émises
     * @return la somme de toutes les intensités émises
     */
    public int getSommeIntensitéTotal() {
        return sommeIntensitéTotal;
    }

    /**
     * le moment de la première émission
     * @return le moment de la première émission
     */
    public Date getMomentPremEmission() {
        return momentPremEmission;
    }

    /**
     * moment de la dernière émission
     * @return le moment de la dernière émission
     */
    public Date getMomentDerEmission() {
        return momentDerEmission;
    }

    /**
     * Activité des émetteurs
     * @return vrai si les émetteurs sont actifs, faux sinon
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * index du dernier émetteur ayant émis
     * @return l'index du dernier émetteur ayant émis
     */
    public int getDerEmetteur() {
        return derEmetteur;
    }
}
