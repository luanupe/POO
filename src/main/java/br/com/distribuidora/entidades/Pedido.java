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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Patricia
 * @modified Luan
 */
@Entity
public class Pedido implements Serializable {
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPedido;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date previsao;
    
    private Long id;
    private String status;
    private Float valor;
    private Fornecedor fornecedor;
    private List<EventoPedido> eventos;
    
    public Pedido() {
        this.eventos=  new ArrayList<EventoPedido>();
    }
    
    public Pedido(Date dataPedido, Date previsao, Fornecedor fornecedor, List<Produto> produtos, Float valor, List<EventoPedido> eventos, String status) {
        this.dataPedido = dataPedido;
        this.previsao = previsao;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.eventos = eventos;
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dataPedido);
        hash = 97 * hash + Objects.hashCode(this.previsao);
        hash = 97 * hash + Objects.hashCode(this.fornecedor);
        hash = 97 * hash + Objects.hashCode(this.valor);
        hash = 97 * hash + Objects.hashCode(this.eventos);
        hash = 97 * hash + Objects.hashCode(this.status);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataPedido, other.dataPedido)) {
            return false;
        }
        if (!Objects.equals(this.previsao, other.previsao)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.eventos, other.eventos)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", dataPedido=" + dataPedido + ", previsao=" + previsao + ", fornecedor=" + fornecedor  + ", valor=" + valor + ", eventos=" + eventos + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Temporal(TemporalType.DATE)
    public Date getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Date previsao) {
        this.previsao = previsao;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    // Pra que serve esse mappedBy?
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Pedido")
    public List<EventoPedido> getEventos() {
        return this.eventos;
    }

    public void setEventos(List<EventoPedido> eventos) {
        this.eventos = eventos;
    }

}
