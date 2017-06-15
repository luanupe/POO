
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Produto;
import java.io.Serializable;

/**
 *
 * @author Patricia
 */
public interface CadastrarProduto extends Serializable{
    
    //public void adicionarProduto (Produto produto,String nome) throws ProdutoExistenteException;
    
    public void removerProduto(String codigoDeBarra) throws ProdutoInexistenteException;
    
    public Produto buscarProduto(String codigoDeBarra) throws ProdutoInexistenteException;
    
   
}
