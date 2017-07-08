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

    public EventoPedido(Pedido pedido, Usuario responsavel, List<Encaminhamento> encaminhamentos, List<Usuario> subcribers){
        super(responsavel, pedido, encaminhamentos, subcribers);
    }

}
