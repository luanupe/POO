
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Pedido;
import br.com.distribuidora.persistencia.RepositorioPedido;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patricia
 */
public class CadastrarPedidoImp implements CadastrarPedido {

    private static final Logger log = LoggerFactory.getLogger(CadastrarPedidoImp.class);
    
    @Autowired
    RepositorioPedido repositorioPedido;
    
    
    
    @Override
    @Transactional(rollbackFor = PedidoExistenteException.class)
    public void adicionarPedido(Pedido pedido) throws PedidoExistenteException {
        try {
            this.buscarPedido(pedido.getId());
            this.log.error("Esse pedido " + pedido.getId() + " já existe.");
            
            // ends
            throw new PedidoExistenteException("Esse pedido " + pedido.getId() + " já existe.");
        } catch (PedidoInexistenteException e) {
            this.repositorioPedido.save(pedido);
            this.log.info("Pedido" + pedido.getId()  + " cadastrado com sucesso.");
        }

    }

    @Override
    @Transactional(rollbackFor = PedidoInexistenteException.class)
    public Pedido buscarPedido(Long id) throws PedidoInexistenteException {
   
    Pedido pedido = this.repositorioPedido.findById(id);
        if ((pedido == null)) {
            throw new PedidoInexistenteException("Pedido" + pedido.getId() + " não existe.");
        }
         return pedido;
    }

    @Override
    public List<Pedido> listarPedido() {
    return (List<Pedido> ) repositorioPedido.findAll();
    }

    @Override
    @Transactional(rollbackFor = PedidoInexistenteException.class)
    public void atualizarPedido(Pedido pedido) throws PedidoInexistenteException {
        Pedido pedidoAntigo = buscarPedido(pedido.getId());
        pedidoAntigo.setDataPedido(pedido.getDataPedido());
        pedidoAntigo.setFornecedor(pedido.getFornecedor());
        pedidoAntigo.setPrevisao(pedido.getPrevisao());
        pedidoAntigo.setEventos(pedido.getEventos());
        pedidoAntigo.setStatus(pedido.getStatus());
        pedidoAntigo.setValor(pedido.getValor());
        
        repositorioPedido.save(pedidoAntigo);
        
    }
    
}
