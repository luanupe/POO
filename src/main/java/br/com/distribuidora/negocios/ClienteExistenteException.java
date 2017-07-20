package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
public class ClienteExistenteException extends Exception {
    
     public ClienteExistenteException() {
        super();
    }

    public ClienteExistenteException(String message) {
        super(message);
    }
}
