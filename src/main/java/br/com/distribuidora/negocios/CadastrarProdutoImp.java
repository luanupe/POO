
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.persistencia.RepositorioProduto;
import java.util.List;
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
    
    
     @Override
     @Transactional(rollbackFor = ProdutoInexistenteException.class)
    public void adicionarProduto(Produto produto) throws ProdutoExistenteException {
        try {
            this.buscarProduto(produto.getCodigoBarra());
            this.log.error("Produto " + produto.getNome() + "com codigo de barra" + produto.getCodigoBarra() + "já existe.");
            
            // ends
            throw new ProdutoExistenteException("Produto " + produto.getNome() + "com codigo de barra" + produto.getCodigoBarra() + "já existe.");
        } catch (ProdutoInexistenteException e) {
            this.repositorioProduto.save(produto);
            this.log.info("Produto " + produto.getNome() + "com codigo de barra" + produto.getCodigoBarra() + "cadastrado com sucesso");
        } 

    }
    
    
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

    @Override
    public List<Produto> listarProduto() {

        return (List<Produto> ) repositorioProduto.findAll();

    }
    
    
    @Override
    @Transactional(rollbackFor = ProdutoInexistenteException.class)
    public void atualizarProduto(Produto produto) throws ProdutoInexistenteException{
        
       Produto produtoAntigo = buscarProduto(produto.getCodigoBarra());
       
       produtoAntigo.setCaracteristicas(produto.getCaracteristicas());
       produtoAntigo.setFabricacao(produto.getFabricacao());
       produtoAntigo.setMarca(produto.getMarca());
       produtoAntigo.setPesoMl(produto.getPesoMl());
       produtoAntigo.setNome(produto.getNome());
       produtoAntigo.setPreco(produto.getPreco());
       produtoAntigo.setValidade(produto.getValidade());
       produtoAntigo.setFornecedores(produto.getFornecedores());
       
       repositorioProduto.save( produtoAntigo);
    }
    
    }

