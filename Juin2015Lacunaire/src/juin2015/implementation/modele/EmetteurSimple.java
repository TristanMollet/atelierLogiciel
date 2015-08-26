/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tritan
 */
public class EmetteurSimple extends JPanel {

    private int nbEmissions;
    private double moyenne;
    private int somme;
    private boolean dernier = false;

    public EmetteurSimple(int nbEmet, double moy, int som) {
        nbEmissions = nbEmet;
        moyenne = moy;
        somme = som;
    }

    public void setDernier(boolean der) {
        dernier = der;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        
        if (dernier) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.BLUE);

        }
        g.fillRect(5, 5, 100, 150);
       
    }
}
