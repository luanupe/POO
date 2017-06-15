
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class FornecedorInexistenteException extends Exception {
  
     public FornecedorInexistenteException() {
        super();
    }

    public FornecedorInexistenteException(String message) {
        super(message);
    }
    
}
