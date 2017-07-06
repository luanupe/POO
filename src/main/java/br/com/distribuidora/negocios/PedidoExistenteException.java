
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class PedidoExistenteException extends Exception {
    
    public PedidoExistenteException() {
        super();
    }

    public PedidoExistenteException(String message) {
        super(message);
    }
}
