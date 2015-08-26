/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;


import java.util.Date;
import juin2015.architecturemvc.EtatEmissions;
import juin2015.architecturemvc.ModelePourControleurs;
import juin2015.architecturemvc.ModelePourVues;
import juin2015.architecturemvc.Vue;
import juin2015.emetteur.EcouteEmissions;
import juin2015.emetteur.GestionEmetteurs;

/**
 *
 */
public class ModeleImp implements ModelePourVues, ModelePourControleurs, EcouteEmissions{
    
    private final GestionEmetteurs gestionnaireEmission;
    
    private EtatEmissions etat;     // dernier etat du modèle
    public ModeleImp(){
        gestionnaireEmission = new GestionEmetteurs();
        etat = new EtatEmissions(0, new int[1], new int[1], new double[1], false, 0, 0, 0, 0);
        notifyEmissionEcouteur();
        
    }
    /**
     * Construit un premier modele
     * @param nbEmetteurs
     * @param nbEmissions
     * @param sommeIntensite
     * @param moyenneIntensite
     * @param actif
     * @param derEmetteur
     * @param nbEmissionTotal
     * @param moyenneIntensiteTotal
     * @param sommeIntensiteTotal 
     */
    public ModeleImp(int nbEmetteurs, int [] nbEmissions, int[] sommeIntensite, 
            double [] moyenneIntensite, boolean actif, int derEmetteur, 
            int nbEmissionTotal, double moyenneIntensiteTotal, int sommeIntensiteTotal){
        
        gestionnaireEmission=new GestionEmetteurs();
        // A faire : construire un premier etat.
        
        etat = new EtatEmissions(nbEmetteurs, nbEmissions, 
                sommeIntensite, moyenneIntensite, actif, 
                derEmetteur, nbEmissionTotal, 
                moyenneIntensiteTotal, sommeIntensiteTotal);
        notifyEmissionEcouteur();
        
    }
    
    //--------------
    // Implémentation des méthodes de EcouteEmission
    //
    @Override
    public void nouvelleEmission(int name, int intensite, Date moment) {
        // ModelImp reçoit la notification d'une émission d'un des émetteurs
        // A faire: construire un nouvel état et prévenir les vues abonnées
        
        //Construction du nouvelle etat.
        
        int nbEmetteurs = etat.getNbEmetteurs();
        int [] nbEmissions = majNbEmissions();
        int[] sommeIntensite = majSommeIntensite(intensite);
        double [] moyenneIntensite = majMoyenneIntensite();
        boolean actif = etat.isActif();
        int derEmetteur =etat.getDerEmetteur();
        int nbEmissionTotal =etat.getNbEmissionTotal()+1;
        double moyenneIntensiteTotal =majMoyenneIntensiteTotal();
        int sommeIntensiteTotal =majSommeIntensiteTotal();
        etat = new EtatEmissions(derEmetteur, nbEmissions, 
                sommeIntensite, moyenneIntensite, actif,
                derEmetteur, nbEmissionTotal, 
                moyenneIntensiteTotal, sommeIntensiteTotal);
        
        // prevenir les vues abonnees
        notifyEmissionEcouteur();
        
    }
    /**
     * Methode privee mettant a jour nbEmissions
     * @return nbEmissions mis a jour
     */
    private int[] majNbEmissions(){
        int [] newNbEmissions = etat.getNbEmissions();
        for(int i = 0; i < etat.getNbEmissions().length;i++){
            newNbEmissions[i] = etat.getNbEmissions()[i] + 1;
        }
        return newNbEmissions;
    }
    /**
     * Methode prive mettant a jour sommeIntensite
     * @param intensite nouvelle intensite emise
     * @return sommeIntensite mis a jour
     */
    private int[] majSommeIntensite(int intensite){
       int[] newSommeIntensite = etat.getSommeIntensite();
       for(int i =0;i<etat.getSommeIntensite().length;i++){
           newSommeIntensite[i] = etat.getSommeIntensite()[i]+intensite;
       }
       return newSommeIntensite;
    }
    
    /**
     * Methode privee mettant a jour moyenneIntensite
     * @return moyenneIntensite mis a jour
     */
    private double[] majMoyenneIntensite(){
        double[] newMoyenneIntensite = etat.getMoyenneIntensite();
        for (int i =0; i< etat.getMoyenneIntensite().length;i++){
            newMoyenneIntensite[i]= etat.getSommeIntensite()[i]/etat.getNbEmissions()[i];
        }
        return newMoyenneIntensite;
    }
    
    /**
     * Methode privee mettant a jour moyenneIntensiteTotal
     * @return la nouvelle moyenne d'intensite total
     */
    private double majMoyenneIntensiteTotal(){
        double sommeMoyenneIntensite =0;
        for(int i =0;i<etat.getMoyenneIntensite().length;i++){
            sommeMoyenneIntensite += etat.getMoyenneIntensite()[i];
        }
        
        return sommeMoyenneIntensite/etat.getNbEmetteurs();
    }
    /**
     * Methode privee mettant a jour sommeIntensiteTotal
     * @return la nouvelle somme d'intesite total
     */
    private int majSommeIntensiteTotal(){
        int newSommeIntensiteTotal =0;
        for(int i =0;i<etat.getSommeIntensite().length;i++){
            newSommeIntensiteTotal += etat.getSommeIntensite()[i];
        }
        return newSommeIntensiteTotal;
    }
    @Override
    public void changeEtat(boolean actif) {
        System.out.println("Dans changeEtat j'etait : "+actif);
        // ModelImp reçoit la notification d'un changement d'état des émetteurs
        //(passage d'actif à inactif ou le contraire)
       // A faire: construire un nouvel état et prévenir les vues abonnées
        
        //construction du nouvel etat
        int nbEmetteurs = etat.getNbEmetteurs();
        int [] nbEmissions = etat.getNbEmissions();
        int[] sommeIntensite = etat.getSommeIntensite();
        double [] moyenneIntensite = etat.getMoyenneIntensite();
        int derEmetteur =etat.getDerEmetteur();
        int nbEmissionTotal =etat.getNbEmissionTotal();
        double moyenneIntensiteTotal =etat.getMoyenneIntensiteTotal();
        int sommeIntensiteTotal =etat.getSommeIntensitéTotal();
        etat = new EtatEmissions(derEmetteur, nbEmissions, 
                sommeIntensite, moyenneIntensite, actif,
                derEmetteur, nbEmissionTotal, 
                moyenneIntensiteTotal, sommeIntensiteTotal);
        
        // prevenir les vues abonnees
        notifyEmissionEcouteur();
    }
    //
    // Fin d'implémentation des méthodes de EcouteEmission
    //--------------

    
    //---------------
    // Implémentation des méthoodes de ModelePourVues
    //
    @Override
    public EtatEmissions getEtat() {
        return etat;
    }

    @Override
    public void addEmissionEcouteur(Vue vue) {
        // A faire : ajouter une vue à la liste des vues
        System.out.println("dans addEmissionEcouteur");
        listeVue.add(vue);
    }

    @Override
    public void removeEmissionEcouteur(Vue vue) {
        // A faire : ôter une vue de la liste des vues
        listeVue.remove(vue);
    }

    @Override
    public void notifyEmissionEcouteur(){
        listeVue.stream().forEach((listeVue1) -> {
            listeVue1.notifieChangement(etat);
        });
    }
     //
    // Fin d'implémentation des méthoodes de ModelePourVues
    //---------------

    
        
    //---------------
    // Implémentation des méthoodes de ModelePourControleurs
    //
    @Override
    public void startEmissions(int nbEmetteurs, int delai, int alea, int duree) {
        gestionnaireEmission.startEmissions(nbEmetteurs, delai, alea, duree, this);
    }

    @Override
    public void stopEmissions() {
        gestionnaireEmission.stopEmissions();
    }

    @Override
    public boolean isActif() {
        return gestionnaireEmission.isActif();
    }    
        
    //
    // Fin d'implémentation des méthoodes de ModelePourControleurs
    //---------------
    
}
