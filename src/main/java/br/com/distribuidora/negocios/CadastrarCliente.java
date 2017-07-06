
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarCliente extends Serializable {
    
    public void adicionarCliente (Cliente cliente) throws ClienteExistenteException;
    
    public Cliente buscarCliente(String cpfCnpj) throws ClienteInexistenteException;
    
    public List<Cliente> listarCliente();
    
    public void atualizarCliente(Cliente cliente) throws ClienteInexistenteException;
}
