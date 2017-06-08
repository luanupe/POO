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

/**
 *
 * @author Patricia
 */
@Entity
public class Categoria implements Serializable{
    
    private Long id;
    private String nome;
    private List<Produto> produtos;
    private int quant;

    public Categoria() {
     
    }
    
    public Categoria(String nome, List<Produto> produtos, int quant) {
        this.nome = nome;
        this.produtos = produtos;
        this.quant = quant;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.produtos);
        hash = 17 * hash + this.quant;
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        if (this.quant != other.quant) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + ", produtos=" + produtos + ", quant=" + quant + '}';
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   @OneToMany(fetch = FetchType.EAGER)
    public List<Produto> getProdutos() {
        return produtos;
    }

   
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

   
    
    
    
    
    
    
}
