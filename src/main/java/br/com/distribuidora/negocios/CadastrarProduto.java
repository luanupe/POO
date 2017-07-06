
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarProduto extends Serializable{
    
    public void adicionarProduto (Produto produto) throws ProdutoExistenteException;
    
    public void removerProduto(String codigoDeBarra) throws ProdutoInexistenteException;
    
    public Produto buscarProduto(String codigoDeBarra) throws ProdutoInexistenteException;
    
    public List<Produto> listarProduto();
    
    public void atualizarProduto (Produto produto) throws ProdutoInexistenteException;
}
   

