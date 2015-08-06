/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.architecturemvc;

/**
 *
 * Méthodes à implémenter par tout objet voulant être une vue du modèle
 */
public interface Vue {    
    /**
     * méthode appelée par le modèle à chaque fois que son état change: nouvelle impulsion, activation ou passivation de la simulation
     * @param etat 
     */
    void  notifieChangement(EtatEmissions etat);
}
