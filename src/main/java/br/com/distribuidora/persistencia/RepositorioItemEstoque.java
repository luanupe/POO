/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.ItemEstoque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Patricia
 */
@Repository
public interface RepositorioItemEstoque extends CrudRepository<ItemEstoque, Long>{
    public ItemEstoque findByIdServico (Long id);
     
}
