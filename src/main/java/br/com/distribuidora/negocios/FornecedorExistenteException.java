
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class FornecedorExistenteException extends Exception {
    
     public FornecedorExistenteException() {
        super();
    }

    public FornecedorExistenteException(String message) {
        super(message);
    }
}
