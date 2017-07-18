
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Fornecedor;
import br.com.distribuidora.persistencia.RepositorioFornecedor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patricia
 */
@Service
public class CadastrarFornecedorImp implements CadastrarFornecedor{

    
    private static final Logger log = LoggerFactory.getLogger(CadastrarFornecedorImp.class);
    
    @Autowired
    private RepositorioFornecedor repositorioFornecedor;
    
    @Override
    @Transactional(rollbackFor = FornecedorExistenteException.class)
    public void adicionarFornecedor(Fornecedor fornecedor) throws FornecedorExistenteException {
        try {
            this.buscarFornecedor(fornecedor.getCnpj());
            this.log.error("Fornecedor " + fornecedor.getCnpj() + " já existe.");
            
            // ends
            throw new FornecedorExistenteException("Fornecedor " + fornecedor.getCnpj() + " já existe.");
        } catch (FornecedorInexistenteException e) {
            this.repositorioFornecedor.save(fornecedor);
            this.log.info("Fornecedor " + fornecedor.getCnpj() + " cadastrado com sucesso.");
        } 
    }

    @Override
    @Transactional(rollbackFor = FornecedorInexistenteException.class)
    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException {
    try {
            Fornecedor fornecedor = this.buscarFornecedor(cnpj);
            this.repositorioFornecedor.delete(fornecedor);
            this.log.info("Fornecedor  " + fornecedor.getCnpj() + " foi removido.");
        } catch (FornecedorInexistenteException e) {
            this.log.error("Fornecedor " + cnpj + " não existe, não pode ser removido.");
            throw e;
        }
    
    }

    @Override
    @Transactional(rollbackFor = FornecedorInexistenteException.class)
    public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorInexistenteException {
     Fornecedor fornecedorAntigo = buscarFornecedor(fornecedor.getCnpj());
       
       fornecedorAntigo.setEmail(fornecedor.getEmail());
       fornecedorAntigo.setEndereco(fornecedor.getEndereco());
       fornecedorAntigo.setNome(fornecedor.getNome());
       fornecedorAntigo.setTelefone(fornecedor.getTelefone());
       
       repositorioFornecedor.save(fornecedorAntigo);
    
    }

    @Override
    @Transactional(rollbackFor = FornecedorInexistenteException.class)
    public Fornecedor buscarFornecedor(String cnpj) throws FornecedorInexistenteException {
     Fornecedor fornecedor = this.repositorioFornecedor.findByCnpj(cnpj);
        if ((fornecedor == null)) {
            throw new FornecedorInexistenteException("Fornecedor " + cnpj + " não existe.");
        }
        return fornecedor;
    
    }
    
}
