/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.architecturemvc;

import java.util.ArrayList;
import java.util.List;
import juin2015.architecturemvc.Vue;



/**
 *
 * Méthodes à implémenter par tout objet se présentant comme modèle aux vues des simulations d'émissions
 */
public interface ModelePourVues {

    /**
     *Liste des vue abonne.
     */
    List<Vue> listeVue = new ArrayList<Vue>();
    /**
     * fournit l'eat de la dernière simulation qu'elle soit active ou inactive
     * @return 
     */
    public EtatEmissions getEtat();
    
    /**
     * inscrit une vue comme écouteur du modèle
     * @param vue 
     */
    public void addEmissionEcouteur(Vue vue);
    
    /**
     * désinscrit une vue comme écouteur du modèle
     * @param vue 
     */
    public void removeEmissionEcouteur(Vue vue);
    
    public void notifyEmissionEcouteur();
    
}
