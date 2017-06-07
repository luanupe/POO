package br.com.distribuidora.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Luan
 */
@Entity
public class Encaminhamento implements Serializable {
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataAberto;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFinalizado;
    
    private Long id;
    private String descricao;
    private String status;

    public Encaminhamento() {
        super();
    }

    public Encaminhamento(Date dataAberto, Date dataFinalizado, String descricao, String status) {
        this.dataAberto = dataAberto;
        this.dataFinalizado = dataFinalizado;
        this.descricao = descricao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Encaminhamento {" + "id=" + id + ", dataAberto=" + dataAberto + ", dataFinalizado=" + dataFinalizado + ", descricao=" + descricao + ", status=" + status + '}';
    }

    @Temporal(TemporalType.DATE)
    public Date getDataAberto() {
        return dataAberto;
    }

    public void setDataAberto(Date dataAberto) {
        this.dataAberto = dataAberto;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(Date dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
