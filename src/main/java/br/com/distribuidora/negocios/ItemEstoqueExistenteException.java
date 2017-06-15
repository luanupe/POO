
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class ItemEstoqueExistenteException extends Exception {
    
     public ItemEstoqueExistenteException() {
        super();
    }

    public ItemEstoqueExistenteException(String message) {
        super(message);
    }
}
