/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.persistencia.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patricia
 */
@Service
public class CadastrarUsuarioImp implements CadastrarUsuario{

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    
    @Override
    @Transactional(rollbackFor = UsuarioExistenteException.class)
    public void adicionarUsuario(Usuario usuario) throws UsuarioExistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerUsuario(String cpf) throws UsuarioInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarUsuario(String cpf) throws UsuarioInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
