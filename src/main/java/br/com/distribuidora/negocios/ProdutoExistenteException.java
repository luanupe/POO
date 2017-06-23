
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class ProdutoExistenteException extends Exception {
    
    public ProdutoExistenteException() {
        super();
    }

    public ProdutoExistenteException(String message) {
        super(message);
    }
}
