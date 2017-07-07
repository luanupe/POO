package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Encaminhamento;
import br.com.distribuidora.entidades.Evento;
import java.io.Serializable;

/**
 *
 * @author LAF
 */
public interface CadastrarNotificacao extends Serializable {

    public void adicionarNotificacao(Evento evento) throws NotificacaoException;

    public void cadastrarEncaminhamento(Evento evento, Encaminhamento encaminhamento) throws NotificacaoException;
    
}
