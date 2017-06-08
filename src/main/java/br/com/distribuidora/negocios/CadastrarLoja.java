
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.listar.LojaListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarLoja extends Serializable {
    
    public void adicionarLoja (Loja loja) throws LojaExistenteException;
    
    public void removerLoja(String cnpj) throws LojaInexistenteException;
    
    public Loja buscarLoja(String cnpj) throws LojaInexistenteException;

   //public LojaListar buscarLoja (String cnpj) throws LojaInexistenteException;
}
