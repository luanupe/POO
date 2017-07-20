package br.com.distribuidora.controllers.formularios;

import br.com.distribuidora.entidades.Usuario;
import java.util.Date;

/**
 *
 * @author LAF
 */
public class CriarUsuarioForm {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String funcao;
    private Float salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setDataDemissao(null);
        usuario.setDataAdmissao(new Date());
        usuario.setNome(this.getNome());
        usuario.setCpf(this.getCpf());
        usuario.setTelefone(this.getTelefone());
        usuario.setEmail(this.getEmail());
        usuario.setEndereco(this.getEndereco());
        usuario.setFuncao(this.getFuncao());
        usuario.setSalario(this.getSalario());
        return usuario;
    }
    
}
