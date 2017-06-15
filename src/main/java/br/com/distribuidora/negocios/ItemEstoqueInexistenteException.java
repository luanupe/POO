
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
public class ItemEstoqueInexistenteException extends Exception {

     public ItemEstoqueInexistenteException() {
        super();
    }

    public ItemEstoqueInexistenteException(String message) {
        super(message);
    }
    
}
