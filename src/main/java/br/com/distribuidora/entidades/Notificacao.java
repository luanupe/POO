package br.com.distribuidora.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Luan
 */
@Entity
public class Notificacao {

    private Long id;
    private Usuario usuario;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNotificacao;
    private boolean lido;
    private Evento evento;
    
    public Notificacao() {
        
    }

    public Notificacao(Usuario usuario, boolean lido, Date dataNotificacao, Evento evento) {
        this.usuario = usuario;
        this.lido = lido;
        this.dataNotificacao = dataNotificacao;
        this.evento = evento;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.getId());
        hash = 67 * hash + Objects.hashCode(this.getUsuario());
        hash = 67 * hash + Objects.hashCode(this.isLido());
        hash = 67 * hash + Objects.hashCode(this.getDataNotificacao());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notificacao other = (Notificacao) obj;
        if (this.lido != other.lido) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.dataNotificacao, other.dataNotificacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notificacao{" + "id=" + id + ", usuario=" + usuario + ", lido=" + lido + ", data=" + dataNotificacao + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public Date getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(Date dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }
    
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
