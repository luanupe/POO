package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Patricia
 */
@Repository
public interface RepositorioVenda extends CrudRepository<Venda, Long> {
    
    public Venda findByIdServico (Long id);
    
}
