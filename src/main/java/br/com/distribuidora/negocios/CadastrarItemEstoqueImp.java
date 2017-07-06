
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.ItemEstoque;
import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.persistencia.RepositorioItemEstoque;
import br.com.distribuidora.persistencia.RepositorioProduto;
import java.util.List;
import java.util.logging.Level;
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
public class CadastrarItemEstoqueImp implements CadastrarItemEstoque{
    
    private static final Logger log = LoggerFactory.getLogger(CadastrarLojaImp.class);
    
    @Autowired
    private RepositorioItemEstoque repositorioItemEstoque;
    
    @Autowired
    private RepositorioProduto repositorioProduto;
    
    @Override
    @Transactional(rollbackFor = ItemEstoqueExistenteException.class)
   public void adicionarItemEstoque(ItemEstoque itemEstoque) throws ItemEstoqueExistenteException {
        try {
            this.buscarItemEstoque(itemEstoque.getProduto().getCodigoBarra());
            this.log.error("Esse produto " + itemEstoque.getProduto() + " já existe.");
            
            // ends
            throw new ItemEstoqueExistenteException("Esse produto " + itemEstoque.getProduto() + " já existe.");
        } catch (ItemEstoqueInexistenteException e) {
            this.repositorioItemEstoque.save(itemEstoque);
            this.log.info("Produto" + itemEstoque.getProduto()  + " cadastrada com sucesso no estoque.");
        }
    }

    
    @Override
    @Transactional(rollbackFor = ItemEstoqueInexistenteException.class)
    public ItemEstoque buscarItemEstoque(String codigoBarra) throws ItemEstoqueInexistenteException{
        ItemEstoque itemEstoque = this.repositorioItemEstoque.findByCodigoBarra(codigoBarra);
        if ((itemEstoque == null)) {
            throw new ItemEstoqueInexistenteException("produto" + itemEstoque.getProduto() + " não existe.");
        }
         return itemEstoque;
    }

    @Override
    public List<ItemEstoque> listarEstoque() {

        return (List<ItemEstoque> ) repositorioItemEstoque.findAll();

    }
    }
       
