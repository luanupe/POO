
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarUsuario {
    
    public void adicionarUsuario(Usuario usuario) throws UsuarioExistenteException;

    public void removerUsuario(String cpf) throws UsuarioInexistenteException;

    public Usuario buscarUsuario(String cpf) throws UsuarioInexistenteException;
    
    public List<Usuario> listarUsuario();

   //public UsuarioListar buscarUsuario (String cpf) throws UsuarioInexistenteException;
}
