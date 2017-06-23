
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class ClienteInexistenteException extends Exception {
    
    public ClienteInexistenteException() {
        super();
    }

    public ClienteInexistenteException(String message) {
        super(message);
    }
}
