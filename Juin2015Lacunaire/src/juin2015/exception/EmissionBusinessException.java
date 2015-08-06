/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juin2015.exception;

/**
 * Exception lanc&eacute;e lorsqu'une méthode de la logique métier rencontre un problème
 */
public class EmissionBusinessException extends EmissionException {

    /**
     * Creates a new instance of <code>BibliothequeDTOException</code> without detail message.
     */
    public EmissionBusinessException() {
    }


    /**
     * Constructs an instance of <code>BibliothequeDTOException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmissionBusinessException(String msg) {
        super(msg);
    }
}
