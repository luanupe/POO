package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 * @modified Luan
 */
public class UsuarioExistenteException extends Exception {

    public UsuarioExistenteException() {
        super();
    }

    public UsuarioExistenteException(String message) {
        super(message);
    }
    
}
