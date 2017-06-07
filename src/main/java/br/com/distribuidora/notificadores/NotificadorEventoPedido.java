package br.com.distribuidora.notificadores;

import br.com.distribuidora.entidades.Evento;
import br.com.distribuidora.entidades.EventoPedido;
import br.com.distribuidora.entidades.Notificacao;
import br.com.distribuidora.persistencia.RepositorioNotificacao;
import br.com.distribuidora.persistencia.RepositorioPedido;
import java.util.Date;

/**
 *
 * @author LAF
 */
public class NotificadorEventoPedido extends NotificadorEvento implements Runnable {

    @Override
    public void run() {
        /*
        Pegar os evento pelo Pedido :)
        */
        
        /*RepositorioPedido repositorio = null;
        for (EventoPedido evento : repositorio.findAll()) {
            this.notificar(evento);
        }*/
    }

    @Override
    public final void notificar(Evento evento) {
        if ((evento instanceof EventoPedido)) {
            Date data = new Date();
            if ((evento.getProximaNotificacao().after(data))) {
                super.notificar(evento);
            }
        }
    }
    
}
