package br.com.distribuidora.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Patricia
 * @modified Luan
 */
@Entity
public class ItemEstoque implements Serializable{
    
    private Long id;
    private Float quant;
    private Produto produto;
    private List<EventoEstoque> eventos;
    
    public ItemEstoque(){
      this.eventos = new ArrayList<EventoEstoque>();
    }
    
    public ItemEstoque(Float quant, List<EventoEstoque> eventos, Produto produto){
        this.quant=quant;
        this.eventos=eventos;
        this.produto=produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.quant);
        hash = 47 * hash + Objects.hashCode(this.eventos);
        hash = 47 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemEstoque other = (ItemEstoque) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quant, other.quant)) {
            return false;
        }
        if (!Objects.equals(this.eventos, other.eventos)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemEstoque{" + "id=" + id + ", quant=" + quant + ", eventos=" + eventos + ", produto=" + produto + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getQuant() {
        return quant;
    }

    public void setQuant(Float quant) {
        this.quant = quant;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="item")
    public List<EventoEstoque> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoEstoque> eventos) {
        this.eventos = eventos;
    }

     @OneToOne(fetch = FetchType.EAGER)
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

  
    
}
