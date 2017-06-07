package br.com.distribuidora.persistencia;

import br.com.distribuidora.entidades.Notificacao;
import br.com.distribuidora.entidades.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luan
 */
@Repository
public interface RepositorioNotificacao extends CrudRepository<Notificacao, Long> {
    
    public Notificacao findByUsuario(Usuario usuario);
    
}
