
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.ItemEstoque;
import java.io.Serializable;

/**
 *
 * @author Patricia
 */
public interface CadastrarItemEstoque extends Serializable{
    
    public void adicionarItemEstoque(ItemEstoque itemEstoque) throws ItemEstoqueExistenteException;
    
    public ItemEstoque buscarItemEstoque(String codigoBarra) throws ItemEstoqueInexistenteException;
      
}
