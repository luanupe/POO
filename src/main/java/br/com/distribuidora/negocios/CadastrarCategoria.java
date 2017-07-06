package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Categoria;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarCategoria extends Serializable{

   public void adicionarCategoria (Categoria categoria) throws CategoriaExistenteException;
    
   public Categoria buscarCategoria(String nome) throws CategoriaInexistenteException;
    
   public void atualizarCategoria (Categoria categoria) throws CategoriaInexistenteException;
    
   public List<Categoria> listarCategoria();
}


