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
public abstract class Evento implements Serializable {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date proximaNotificacao;

    private Long id;
    private Usuario responsavel;
    private Pedido pedido;
    private List<Usuario> subcribers;
    private List<Encaminhamento> encaminhamentos;
    
    public Evento(){
        this.encaminhamentos = new ArrayList<Encaminhamento>();
        this.subcribers = new ArrayList<Usuario>();
    }
    
    public Evento(Usuario responsavel, Pedido pedido, List<Encaminhamento> encaminhamentos, List<Usuario> subcribers){
        this.responsavel = responsavel;
        this.encaminhamentos = encaminhamentos;
        this.subcribers = subcribers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.responsavel);
        hash = 29 * hash + Objects.hashCode(this.pedido);
        hash = 29 * hash + Objects.hashCode(this.subcribers);
        hash = 29 * hash + Objects.hashCode(this.encaminhamentos);
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
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.encaminhamentos, other.encaminhamentos)) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        if (!Objects.equals(this.subcribers, other.subcribers)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evento {" + "id=" + id + ", encaminhamentos=" + encaminhamentos + ", responsavel=" + responsavel.getNome() + ", subcribes=" + subcribers + '}';
    }

    @Temporal(TemporalType.DATE)
    public Date getProximaNotificacao() {
        return this.proximaNotificacao;
    }

    public void setProximaNotificacao(Date proximaNotificacao) {
        this.proximaNotificacao = proximaNotificacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Usuario getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @OneToMany(fetch = FetchType.EAGER)
    public List<Encaminhamento> getEncaminhamentos() {
        return this.encaminhamentos;
    }

    public void setEncaminhamentos(List<Encaminhamento> encaminhamentos) {
        this.encaminhamentos = encaminhamentos;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Usuario> getSubcribers() {
        return this.subcribers;
    }

    public void setSubcribes(List<Usuario> subcribers) {
        this.subcribers = subcribers;
    }
    
}
