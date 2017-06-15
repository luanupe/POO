
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Fornecedor;
import java.io.Serializable;

/**
 *
 * @author Patricia
 */
public interface CadastrarFornecedor extends Serializable {
    
   public void adicionarFornecedor (Fornecedor fornecedor) throws FornecedorExistenteException;
    
    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException;
    
    public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorInexistenteException;
    
    public Fornecedor buscarFornecedor(String cnpj) throws FornecedorInexistenteException;  
}
