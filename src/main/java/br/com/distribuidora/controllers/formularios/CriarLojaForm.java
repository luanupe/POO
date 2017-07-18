package br.com.distribuidora.controllers.formularios;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Usuario;
import java.util.Date;

/**
 *
 * @author LAF
 */
public class CriarLojaForm {
    
    // Dados do usuario
    private String nomeUsuario;
    private String cpfUsuario;
    private String telefoneUsuario;
    private String emailUsuario;
    private String enderecoUsuario;
    private String funcaoUsuario;
    private Float salarioUsuario;
    private Date dataAdmissaoUsuario;
    
    // Dados da loja
    private String nomeLoja;
    private String enderecoLoja;
    private String cnpjLoja;
    private String telefoneLoja;
    private String emailLoja;

    // Informações do usuário

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getFuncaoUsuario() {
        return funcaoUsuario;
    }

    public void setFuncaoUsuario(String funcaoUsuario) {
        this.funcaoUsuario = funcaoUsuario;
    }

    public Float getSalarioUsuario() {
        return salarioUsuario;
    }

    public void setSalarioUsuario(Float salarioUsuario) {
        this.salarioUsuario = salarioUsuario;
    }

    public Date getDataAdmissaoUsuario() {
        return dataAdmissaoUsuario;
    }

    public void setDataAdmissaoUsuario(Date dataAdmissaoUsuario) {
        this.dataAdmissaoUsuario = dataAdmissaoUsuario;
    }

    // Informações da Loja

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(String enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }

    public String getCnpjLoja() {
        return cnpjLoja;
    }

    public void setCnpjLoja(String cnpjLoja) {
        this.cnpjLoja = cnpjLoja;
    }

    public String getTelefoneLoja() {
        return telefoneLoja;
    }

    public void setTelefoneLoja(String telefoneLoja) {
        this.telefoneLoja = telefoneLoja;
    }

    public String getEmailLoja() {
        return emailLoja;
    }

    public void setEmailLoja(String emailLoja) {
        this.emailLoja = emailLoja;
    }

    // Métodos auxiliares

    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.getNomeUsuario());
        usuario.setCpf(getCpfUsuario());
        usuario.setTelefone(getTelefoneUsuario());
        usuario.setEmail(getEmailUsuario());
        usuario.setEndereco(getEnderecoUsuario());
        usuario.setFuncao(getFuncaoUsuario());
        usuario.setSalario(getSalarioUsuario());
        usuario.setDataAdmissao(this.getDataAdmissaoUsuario());
        return usuario;
    }

    public Loja getLoja() {
        Loja loja = new Loja();
        loja.setNome(this.getNomeLoja());
        loja.setEndereco(this.getEnderecoLoja());
        loja.setCnpj(this.getCnpjLoja());
        loja.setTelefone(this.getTelefoneLoja());
        loja.setEmail(this.getEmailLoja());
        return loja;
    }
    
}
