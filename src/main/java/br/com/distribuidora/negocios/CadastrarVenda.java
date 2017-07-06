
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Venda;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Patricia
 */
public interface CadastrarVenda extends Serializable {
    
    public Venda buscarVenda(Long id) throws VendaInexistenteException;
    
    public List<Venda> listarVenda();
}
