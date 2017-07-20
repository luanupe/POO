package br.com.distribuidora.controllers.formularios;

import br.com.distribuidora.entidades.Produto;
import java.util.Date;

/**
 *
 * @author LAF
 */
public class ProdutoCadastrarForm {

    private String nome;
    private String marca;
    private Float peso;
    private Float preco;
    private Date validade;
    private Date fabricacao;
    private String caracteristicas;
    private String codigoBarra;

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

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

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
    
    public Produto getProduto() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setPesoMl(peso);
        produto.setPreco(preco);
        produto.setValidade(validade);
        produto.setFabricacao(fabricacao);
        produto.setCaracteristicas(caracteristicas);
        produto.setCodigoBarra(codigoBarra);
        return produto;
    }
    
}
