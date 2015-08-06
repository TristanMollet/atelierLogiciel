/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juin2015.exception;

/**
 * Exception lanc&eacute;e par les acc&eacute;s db
 */
public class EmissionDbException extends EmissionException {

    /**
     * Creates a new instance of <code>BibliothequeDBException</code> without detail message.
     */
    public EmissionDbException() {
    }


    /**
     * Constructs an instance of <code>BibliothequeDBException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmissionDbException(String msg) {
        super(msg);
    }
}
