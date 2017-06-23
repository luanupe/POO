/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 */
class ClienteExistenteException extends Exception {
    
     public ClienteExistenteException() {
        super();
    }

    public ClienteExistenteException(String message) {
        super(message);
    }
}
