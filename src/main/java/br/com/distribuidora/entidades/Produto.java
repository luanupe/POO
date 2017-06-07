/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Produto implements Serializable{
    private Long id;
    private String nome;
    private String marca;
    private Float pesoMl;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date validade;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fabricacao;
    private String caracteristicas;
    private String codigoBarra;
    private List<Fornecedor> fornecedores;
    
    public Produto(){
    this.fornecedores= new ArrayList<Fornecedor>();
}
    
    public Produto(String nome, String marca, Float pesoMl, Date validade, Date fabricacao, String caracteristicas, String codigoBarra, List<Fornecedor> fornecedores){
        this.nome=nome;
        this.marca=marca;
        this.pesoMl=pesoMl;
        this.validade=validade;
        this.fabricacao=fabricacao;
        this.caracteristicas=caracteristicas;
        this.codigoBarra=codigoBarra;
        this.fornecedores=fornecedores;
      
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.pesoMl);
        hash = 67 * hash + Objects.hashCode(this.validade);
        hash = 67 * hash + Objects.hashCode(this.fabricacao);
        hash = 67 * hash + Objects.hashCode(this.caracteristicas);
        hash = 67 * hash + Objects.hashCode(this.codigoBarra);
        hash = 67 * hash + Objects.hashCode(this.fornecedores);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.pesoMl, other.pesoMl)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        if (!Objects.equals(this.fabricacao, other.fabricacao)) {
            return false;
        }
        if (!Objects.equals(this.caracteristicas, other.caracteristicas)) {
            return false;
        }
        if (!Objects.equals(this.codigoBarra, other.codigoBarra)) {
            return false;
        }
        if (!Objects.equals(this.fornecedores, other.fornecedores)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", pesoMl=" + pesoMl + ", validade=" + validade + ", fabricacao=" + fabricacao + ", caracteristicas=" + caracteristicas + ", codigoBarra=" + codigoBarra + ", fornecedores=" + fornecedores + '}';
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Float getPesoMl() {
        return pesoMl;
    }

    public void setPesoMl(Float pesoMl) {
        this.pesoMl = pesoMl;
    }

     @Temporal(TemporalType.DATE)
    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

     @Temporal(TemporalType.DATE)
    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    
    
    
}
