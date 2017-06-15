/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Cliente;
import java.io.Serializable;

/**
 *
 * @author Patricia
 */
public interface CadastrarCliente extends Serializable {
    
     public void adicionarCliente (Cliente cliente) throws ClienteExistenteException;
    
    public Cliente buscarCliente(String cpfCnpj) throws ClienteInexistenteException;
    
    
   public void atualizarCliente(Cliente cliente) throws ClienteInexistenteException;
}
