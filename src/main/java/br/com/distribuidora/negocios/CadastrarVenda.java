
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.entidades.Venda;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarVenda extends Serializable {
    
    public void adicionarVenda(Venda venda) throws VendaExistenteException;
    
    public void adicionarProduto(Venda venda, Produto produto) throws VendaException;
    
    public void removerProduto(Venda venda, Produto produto) throws VendaException;
    
    public void atualizarVenda(Venda venda) throws VendaException;
    
    public Venda buscarVenda(Long id) throws VendaInexistenteException;
    
    public List<Venda> listarVenda();
}
