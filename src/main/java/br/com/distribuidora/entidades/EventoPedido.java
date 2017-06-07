package br.com.distribuidora.entidades;

import java.util.List;
import javax.persistence.Entity;

/**
 * @author Patricia
 * @modified Luan
 */
@Entity
public class EventoPedido extends Evento {

    public EventoPedido() {
        super();
    }

    public EventoPedido(Pedido pedido, List<Encaminhamento> encaminhamentos, Usuario responsavel, List<Usuario> subcribes){
        super(responsavel, pedido, encaminhamentos, subcribes);
    }

}
