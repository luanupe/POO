package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
public class ClienteInexistenteException extends Exception {
    
    public ClienteInexistenteException() {
        super();
    }

    public ClienteInexistenteException(String message) {
        super(message);
    }
}
