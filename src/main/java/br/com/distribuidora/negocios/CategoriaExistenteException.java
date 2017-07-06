
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class CategoriaExistenteException extends Exception {
     public CategoriaExistenteException() {
        super();
    }

    public CategoriaExistenteException(String message) {
        super(message);
    }
}
