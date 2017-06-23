
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class CategoriaInexistenteException extends Exception {
    
     public CategoriaInexistenteException() {
        super();
    }

    public CategoriaInexistenteException(String message) {
        super(message);
    }
}
