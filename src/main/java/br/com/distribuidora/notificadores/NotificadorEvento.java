package br.com.distribuidora.notificadores;

import br.com.distribuidora.entidades.Evento;
import br.com.distribuidora.entidades.Notificacao;
import br.com.distribuidora.entidades.Usuario;
import java.util.Date;

/**
 *
 * @author LAF
 */
public abstract class NotificadorEvento {
    
    public void notificar(Evento evento) {
        Notificacao notificacao = this.gerarNotificacao(evento, evento.getResponsavel());
        // TODO Persistir notificacao
        
        for (Usuario subscriber : evento.getSubcribers()) {
            notificacao = this.gerarNotificacao(evento, subscriber);
            // TODO Persistir notificação
        }
    }

    private Notificacao gerarNotificacao(Evento evento, Usuario usuario) {
        Notificacao notificacao = new Notificacao(usuario, null, true, new Date());
        return notificacao;
    }
    
}
