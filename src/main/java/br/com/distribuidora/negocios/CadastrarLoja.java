
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Venda;
import java.io.Serializable;

/**
 *
 * @author Patricia
 * @modified Luan
 */
public interface CadastrarLoja extends Serializable {
    
    public void adicionarLoja (Loja loja) throws LojaExistenteException;
    
    public void removerLoja(String cnpj) throws LojaInexistenteException;
    
    public Iterable<Loja> buscar();
    
    public Loja buscarLoja(String cnpj) throws LojaInexistenteException;

    public void vender(Loja loja, Venda venda) throws VendaException;

   //public LojaListar buscarLoja (String cnpj) throws LojaInexistenteException;
}
