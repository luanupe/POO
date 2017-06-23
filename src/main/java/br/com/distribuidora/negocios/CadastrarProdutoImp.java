
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.persistencia.RepositorioCategoria;
import br.com.distribuidora.persistencia.RepositorioProduto;
import java.io.Serializable;
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
public class CadastrarProdutoImp implements CadastrarProduto{
  
    private static final Logger log = LoggerFactory.getLogger(CadastrarLojaImp.class);

    
    @Autowired
    private RepositorioProduto repositorioProduto;
    
    //FALTA O ADICIONAR NÃO SABIA SE ERA AQUI OU EM CATEGORIA
    //@Autowired
   // private RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional(rollbackFor = ProdutoInexistenteException.class)
    public void removerProduto(String codigoDeBarra) throws ProdutoInexistenteException {
    try {
            Produto produto = this.buscarProduto(codigoDeBarra);
            this.repositorioProduto.delete(produto);
            this.log.info("Produto " + codigoDeBarra + " foi removido.");
        } catch (ProdutoInexistenteException e) {
            this.log.error("Produto " + codigoDeBarra + " não existe, não pode ser removido.");
            throw e;
        }
    
    }

    @Override
    @Transactional(rollbackFor = ProdutoInexistenteException.class)
    public Produto buscarProduto(String codigoDeBarra) throws ProdutoInexistenteException {
        Produto produto = this.repositorioProduto.findByCodigoBarra(codigoDeBarra);
        if ((produto == null)) {
            throw new ProdutoInexistenteException("Produto " + codigoDeBarra + " não existe.");
        }
        return produto;

    }
    
    
    }

