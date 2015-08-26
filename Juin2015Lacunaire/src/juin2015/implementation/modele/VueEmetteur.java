/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;

import java.awt.GridLayout;
import javax.swing.SwingUtilities;
import juin2015.architecturemvc.EtatEmissions;
import juin2015.architecturemvc.Vue;

/**
 *
 * @author Tritan
 */
public class VueEmetteur extends javax.swing.JPanel implements Vue {

    private ModeleImp model;
    private GridLayout layout = new GridLayout();

    /**
     * Creates new form VueEmetteur
     *
     * @param modele
     */
    public VueEmetteur(ModeleImp modele) {
        model = modele;
        initComponents();
        model.addEmissionEcouteur(this);
        
        setLayout(layout);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public synchronized void notifieChangement(EtatEmissions etat) {
        System.out.println("notfieChangement vueEmetteur");
        System.out.println("nbEmetteur = " +etat.getNbEmetteurs());
        for (int i = 0; i < etat.getNbEmetteurs(); i++) {
            EmetteurSimple emet = new EmetteurSimple(etat.getNbEmissions()[i],
                    etat.getMoyenneIntensite()[i],
                    etat.getSommeIntensite()[i]);
            add(emet);
            if (i == etat.getDerEmetteur()) {
                emet.setDernier(true);
            }
        }
        validate();
       
       /* ok mais tjs en petits --' 
        SwingUtilities.windowForComponent(this).pack();
*/
    }
}