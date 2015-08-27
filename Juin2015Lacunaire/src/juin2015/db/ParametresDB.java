/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juin2015.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import juin2015.dto.ParametresDto;
import juin2015.dto.ParametresSel;
import juin2015.exception.EmissionDbException;



/**
 * Classe d'accès au gestionnaire de persistance des paramètres
 */
public class ParametresDB {

    public static void addParametre(ParametresDto parametre){
        try{
            String query = "INSERT INTO Parametres(nomSerie, nbEmetteurs, duree,"
                    + "delai, alea) "
                    + " VALUES(?, ?, ?, ?, ?)";

            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert = connexion.prepareStatement(query);
            insert.setString(1, parametre.getId());
            insert.setInt(2, parametre.getNbEmetteurs());
            insert.setInt(3, parametre.getDuree());
            insert.setInt(4, parametre.getDelai());
            insert.setInt(5, parametre.getAlea());
            insert.execute();
        } catch (EmissionDbException ex) {
            Logger.getLogger(ParametresDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ParametresDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Collection<ParametresDto> getAllParametres(){
        List<ParametresDto> al = new ArrayList<>();
        try{
            String query = "Select * from Parametres";
            java.sql.Connection connexion = DBManager.getConnection();
        java.sql.PreparedStatement select;
        select = connexion.prepareStatement(query);
        java.sql.ResultSet rs = select.executeQuery();
            while (rs.next()) {
                ParametresDto dt = new ParametresDto(rs.getString("nomSerie"), rs.getInt("nbEmetteurs"),
                        rs.getInt("duree"),rs.getInt("delai"), rs.getInt("alea"));
                al.add(dt);
                
            }
        } catch (EmissionDbException ex) {
            Logger.getLogger(ParametresDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ParametresDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    public static Collection<ParametresDto> getParametres(ParametresSel sel){
        List<ParametresDto> al = new ArrayList<>();
        try{
        String query = "Select nomSerie, nbEmetteurs, duree, delai, alea from Parametres";
               // + "where nomSerie like ?";
        
        java.sql.Connection connexion = DBManager.getConnection();
        java.sql.PreparedStatement select;
        select = connexion.prepareStatement(query);
       // String deb = sel.getDebNom() +"%";
        //select.setString(1, deb);
        java.sql.ResultSet rs = select.executeQuery();
        while(rs.next()){
            ParametresDto dt = new ParametresDto(rs.getString("nomSerie"), 
                    rs.getInt("nbEmetteurs"), rs.getInt("duree"), 
                    rs.getInt("delai"), rs.getInt("alea"));
            al.add(dt);
        }
        }catch(EmissionDbException ex){
            Logger.getLogger(ParametresDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ParametresDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return al;
    }
}
