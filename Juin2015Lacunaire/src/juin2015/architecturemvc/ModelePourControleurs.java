/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.architecturemvc;



/**
 *  Méthodes à implémenter par tout objet se présentant comme modèle aux contrôleurs d'émissions
 * 
 */
public interface ModelePourControleurs {
    /**
     * Lance les émetteurs avec les différents paramètres
     * @param nbEmetteurs  nombre d'émetteurs
     * @param delai délai minimum, en secondes, entre deux émission d'un même émetteur
     * @param alea  aléatoirement l'émetteur émettra après 'delai' secondes.  La probabilité d'émission est de 1 sur alea.
     * @param duree durée maximum de l'expérience exprimée en secondes
     */
    public void startEmissions(int nbEmetteurs, int delai, int alea, int duree);
    
    /**
     * Arrête l'ensemble des émetteurs
     */
    public void stopEmissions();
    
    /**
     * Activité des émetteurs
     * @return vrai ou faux en fonction du fait que les émetteurs sont actifs ou non
     */
    public boolean isActif();   
}
