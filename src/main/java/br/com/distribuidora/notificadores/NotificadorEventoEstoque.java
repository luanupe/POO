package br.com.distribuidora.notificadores;

import br.com.distribuidora.entidades.Evento;
import br.com.distribuidora.entidades.EventoEstoque;

/**
 *
 * @author LAF
 */
public class NotificadorEventoEstoque extends NotificadorEvento {
    
    @Override
    public final void notificar(Evento evento) {
        if ((evento instanceof EventoEstoque)) {
            EventoEstoque estoque = (EventoEstoque) evento;
            if ((estoque.getItem().getQuant() <= estoque.getQuantidade())) {
                super.notificar(evento);
            }
        }
    }
    
}
