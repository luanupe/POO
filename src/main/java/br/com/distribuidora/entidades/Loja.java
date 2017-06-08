
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
public class Loja implements Serializable{
    
    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private String telefone;
    private String email;
    private List<ItemEstoque> estoque;
    private List<Venda> vendas;
    private List<Usuario> usuarios;
    
    public Loja() {
        this.estoque = new ArrayList<ItemEstoque>();
        // ...
    }

    public Loja(String nome, String endereco, String cnpj, String telefone, String email, List<ItemEstoque> estoque, List<Venda> vendas, List<Usuario> usuarios){
        this.nome=nome;
        this.endereco=endereco;
        this.cnpj=cnpj;
        this.telefone=telefone;
        this.email=email;
        this.estoque=estoque;
        this.vendas=vendas;
        this.usuarios=usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.endereco);
        hash = 67 * hash + Objects.hashCode(this.cnpj);
        hash = 67 * hash + Objects.hashCode(this.telefone);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.estoque);
        hash = 67 * hash + Objects.hashCode(this.vendas);
        hash = 67 * hash + Objects.hashCode(this.usuarios);
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
        final Loja other = (Loja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.estoque, other.estoque)) {
            return false;
        }
        if (!Objects.equals(this.vendas, other.vendas)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Loja{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cnpj=" + cnpj + ", telefone=" + telefone + ", email=" + email + ", estoque=" + estoque + ", vendas=" + vendas + ", usuarios=" + usuarios + '}';
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

    @OneToMany(fetch = FetchType.EAGER)
    public List<ItemEstoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<ItemEstoque> estoque) {
        this.estoque = estoque;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
