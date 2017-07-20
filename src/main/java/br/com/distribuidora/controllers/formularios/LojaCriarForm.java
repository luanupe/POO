package br.com.distribuidora.controllers.formularios;

import br.com.distribuidora.entidades.Loja;

/**
 *
 * @author LAF
 */
public class LojaCriarForm {

    private String nome;
    private String endereco;
    private String cnpj;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos auxiliares

    public Loja getLoja() {
        Loja loja = new Loja();
        loja.setNome(this.getNome());
        loja.setEndereco(this.getEndereco());
        loja.setCnpj(this.getCnpj());
        loja.setTelefone(this.getTelefone());
        loja.setEmail(this.getEmail());
        return loja;
    }
    
}
