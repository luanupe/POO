package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Patricia
 */
@Repository
public interface RepositorioProduto extends CrudRepository<Produto, Long>{

    public Produto findByCodigoBarra (String codigoBarra);

}
