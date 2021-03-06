/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;

import juin2015.architecturemvc.EtatEmissions;
import juin2015.architecturemvc.Vue;

/**
 *
 * @author Tritan
 */
public class VueSynthese extends javax.swing.JPanel implements Vue{

    private ModeleImp model;
    /**
     * Creates new form VueSynthese
     * @param modele
     */
    public VueSynthese(ModeleImp modele) {
        model = modele;
        initComponents();
        model.addEmissionEcouteur(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlNbEmissions = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlIntensiteMoyenne = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlTotalIntensite = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlActif = new javax.swing.JLabel();

        jLabel1.setText("Nombres d'émissions : ");

        jlNbEmissions.setText("  ");

        jLabel2.setText("Intensité moyenne :");

        jlIntensiteMoyenne.setText("  ");

        jLabel3.setText("Total intensité :");

        jlTotalIntensite.setText(" ");

        jLabel4.setText("Actif : ");

        jlActif.setText("  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlNbEmissions, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jlIntensiteMoyenne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlTotalIntensite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlActif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlNbEmissions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlIntensiteMoyenne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlTotalIntensite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlActif))
                .addContainerGap(202, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlActif;
    private javax.swing.JLabel jlIntensiteMoyenne;
    private javax.swing.JLabel jlNbEmissions;
    private javax.swing.JLabel jlTotalIntensite;
    // End of variables declaration//GEN-END:variables

    @Override
    public synchronized void notifieChangement(EtatEmissions etat) {
        jlNbEmissions.setText(Integer.toString(etat.getNbEmissionTotal()));
        jlIntensiteMoyenne.setText(Double.toString(etat.getMoyenneIntensiteTotal()));
        jlTotalIntensite.setText(Integer.toString(etat.getSommeIntensitéTotal()));
        if(etat.isActif()){
            jlActif.setText("oui");
        }else{
            jlActif.setText("non");
        }
        validate();
    }
}
