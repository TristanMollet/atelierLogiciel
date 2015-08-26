/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.implementation.modele;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.JPCritSelGenerique;
import be.esi.alg2.gui.outils.MaJTable;
import java.awt.Frame;
import java.util.Collection;
import juin2015.db.ParametresDB;
import juin2015.dto.ParametresDto;
import juin2015.dto.ParametresSel;

/**
 *
 * @author Tritan
 */
public class JDRechParametres extends JDRechGenerique<ParametresSel, ParametresDto>{

    public JDRechParametres(Frame parent, boolean modal, String title, JPCritSelGenerique<ParametresSel> crit, MaJTable<ParametresDto> jT) {
        super(parent, modal, title, crit, jT);
    }

   

    @Override
    protected Collection<ParametresDto> recherche(ParametresSel s) throws Exception {
       return ParametresDB.getParametres(s);
    }
    
}
