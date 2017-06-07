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
 *
 * @author Patricia
 */
@Entity
public class Venda implements Serializable {
    
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataVenda;
    private String tipoPagamento;
    private Float valor;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataEntrega;
    private Usuario usuario;
    private Cliente cliente;
    private List<Produto> produtos;
    
       
    
    public Venda()  {
        this.produtos = new ArrayList<Produto>();
    }

    public Venda(Date dataVenda,String tipoPagamento, Float valor, Date dataEntrega, Usuario usuario, Cliente cliente, List<Produto> produtos ){
        this.dataVenda=dataVenda;
        this.tipoPagamento=tipoPagamento;
        this.valor=valor;
        this.dataEntrega=dataEntrega;
        this.usuario=usuario;
        this.cliente=cliente;
        this.produtos=produtos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.dataVenda);
        hash = 83 * hash + Objects.hashCode(this.tipoPagamento);
        hash = 83 * hash + Objects.hashCode(this.valor);
        hash = 83 * hash + Objects.hashCode(this.dataEntrega);
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + Objects.hashCode(this.produtos);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        if (!Objects.equals(this.tipoPagamento, other.tipoPagamento)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.dataEntrega, other.dataEntrega)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", tipoPagamento=" + tipoPagamento + ", valor=" + valor + ", dataEntrega=" + dataEntrega + ", usuario=" + usuario + ", cliente=" + cliente + ", produtos=" + produtos + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
 
}
