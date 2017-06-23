
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class ProdutoInexistenteException extends Exception {
    
    public ProdutoInexistenteException() {
        super();
    }

    public ProdutoInexistenteException(String message) {
        super(message);
    }
    
}
