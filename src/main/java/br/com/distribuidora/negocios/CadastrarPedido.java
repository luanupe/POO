
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Pedido;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarPedido extends Serializable {
    
    public void adicionarPedido(Pedido pedido) throws PedidoExistenteException;
    
    public Pedido buscarPedido(Long id) throws PedidoInexistenteException;
      
    public List<Pedido> listarPedido();
    
    public void atualizarPedido(Pedido pedido) throws PedidoInexistenteException;
}
