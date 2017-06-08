/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.distribuidora.negocios;

/**
 *
 * @author Patricia
 * @modified Luan
 */
class UsuarioExistenteException extends Exception {

    public UsuarioExistenteException() {
        super();
    }

    public UsuarioExistenteException(String message) {
        super(message);
    }
    
}
