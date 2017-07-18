package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
public class UsuarioInexistenteException extends Exception {

    public UsuarioInexistenteException() {
        super();
    }

    public UsuarioInexistenteException(String message) {
        super(message);
    }
    
}
