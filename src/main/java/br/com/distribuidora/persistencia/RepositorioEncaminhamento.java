package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Encaminhamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAF
 */
@Repository
public interface RepositorioEncaminhamento  extends CrudRepository<Encaminhamento, Long> {

    

}
