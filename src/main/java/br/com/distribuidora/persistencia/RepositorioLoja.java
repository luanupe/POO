
package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Loja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Patricia
 */
@Repository
public interface RepositorioLoja extends CrudRepository<Loja, Long>{
    public Loja findByNome(String nome);
    public Loja findByCnpj(String cnpj);
    
}
