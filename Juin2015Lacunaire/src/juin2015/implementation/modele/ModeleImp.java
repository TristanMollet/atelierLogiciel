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
        gestionnaireEmission=new GestionEmetteurs();
        // A faire : construire un premier etat
        
        
    }
    
    //--------------
    // Implémentation des méthodes de EcouteEmission
    //
    @Override
    public void nouvelleEmission(int name, int intensite, Date moment) {
        // ModelImp reçoit la notification d'une émission d'un des émetteurs
        // A faire: construire un nouvel état et prévenir les vues abonnées
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeEtat(boolean actif) {
        // ModelImp reçoit la notification d'un changement d'état des émetteurs (passage d'actif à inactif ou le contraire)
       // A faire: construire un nouvel état et prévenir les vues abonnées
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEmissionEcouteur(Vue vue) {
        // A faire : ôter une vue de la liste des vues
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
