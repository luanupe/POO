
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class PedidoInexistenteException extends Exception {
   
    public PedidoInexistenteException() {
        super();
    }

    public PedidoInexistenteException(String message) {
        super(message);
    }
}
