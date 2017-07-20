
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
public class VendaInexistenteException extends Exception {
    
     public VendaInexistenteException() {
        super();
    }

    public VendaInexistenteException(String message) {
        super(message);
    }
}
