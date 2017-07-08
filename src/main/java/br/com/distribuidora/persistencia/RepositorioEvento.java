package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAF
 */
@Repository
public interface RepositorioEvento extends CrudRepository<Evento, Long> {

    

}
