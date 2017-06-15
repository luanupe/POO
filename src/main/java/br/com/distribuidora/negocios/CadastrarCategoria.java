package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Categoria;
import java.io.Serializable;

/**
 *
 * @author Patricia
 */
public interface CadastrarCategoria extends Serializable{
// Nao vai remover categoria
   // public void adicionarProdutoNaCategoria(List<Produto> produto, Venda venda) throws VendaException;
     public Categoria buscarCategoria(String nome) throws CategoriaInexistenteException;
}
