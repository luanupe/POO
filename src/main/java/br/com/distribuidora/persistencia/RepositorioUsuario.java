/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Patricia
 */
@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long>{
   
    public Usuario findByCpfCnpj(String cpfCnpj);
}
