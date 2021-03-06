package br.com.distribuidora.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Patricia
 * @modified Luan
 */
@Entity
public class EventoEstoque extends Evento {
    
    private ItemEstoque item;
    private int quantidade;
    
    public EventoEstoque() {
        super();
    }
    
    public EventoEstoque(ItemEstoque item, int quantidade, Pedido pedido, Usuario responsavel, List<Encaminhamento> encaminhamentos, List<Usuario> subcribes){
        super(responsavel, pedido, encaminhamentos, subcribes);
        this.item = item;
        this.quantidade = quantidade;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    public ItemEstoque getItem() {
        return this.item;
    }

    public void setItem(ItemEstoque item) {
        this.item = item;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
