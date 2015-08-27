/*
 * DBManager.java
 */
package juin2015.db;


import juin2015.exception.EmissionDbException;
import java.sql.*;
import juin2015.exception.EmissionException;

/**
 * Offre les outils de connexion et de gestion de transaction. 
 */
public class DBManager {

    private static Connection connection;
    //private static MesParametresDeConnexion dbChoisie;

    /**
     * Mémorise la connexion passée en paramètre
     */
    public static void setConnection(Connection con) {
        connection = con;
    }

    /**
     * Retourne la connexion établie ou à défaut, l'établit
     * @return la connexion établie.
     * @throws juin2015.exception.EmissionDbException
     */
    public static Connection getConnection() throws EmissionDbException {
        try{
        if (connection == null) {
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Parametres", "app", "app");
        }
        connection.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new EmissionDbException("Connexion non réalisable!" + ex.getMessage());
            }
        return connection;
    }
    /**
     * débute une transaction
     */
    public static void startTransaction() throws EmissionException  {
        try {

            getConnection().setAutoCommit(false);
        } catch (SQLException | EmissionDbException ex) {
            throw new EmissionException("Impossible de démarrer une transaction: "+ex.getMessage());
        }
    }

    /**
     * débute une transaction en spécifiant son niveau d'isolation
     * Attention, ceci n'est pas implémenté sous Access!
     * (cette notion sera abordée ultérieurement dans le cours de bd)
     */
    public static void startTransaction(int isolationLevel) throws EmissionException {
        try {
            getConnection().setAutoCommit(false);

            int isol = 0;
            switch (isolationLevel) {
                case 0:
                    isol = java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;
                    break;
                case 1:
                    isol = java.sql.Connection.TRANSACTION_READ_COMMITTED;
                    break;
                case 2:
                    isol = java.sql.Connection.TRANSACTION_REPEATABLE_READ;
                    break;
                case 3:
                    isol = java.sql.Connection.TRANSACTION_SERIALIZABLE;
                    break;
                default:
                    throw new EmissionException("Degré d'isolation inexistant!");
            }


            getConnection().setTransactionIsolation(isolationLevel);
        } catch (SQLException ex) {
            throw new EmissionException("Impossible de démarrer une transaction: "+ex.getMessage());
        }
    }

    /**
     * valide la transaction courante
     */
    public static void valideTransaction() throws EmissionException {
        try {
            getConnection().commit();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new EmissionException("Impossible de valider la transaction: "+ex.getMessage());
        }
    }

    /**
     * annule la transaction courante
     */
    public static void annuleTransaction() throws EmissionException {
        try {
            getConnection().rollback();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new EmissionException("Impossible d'annuler la transaction: "+ex.getMessage());
        }
    }

}
