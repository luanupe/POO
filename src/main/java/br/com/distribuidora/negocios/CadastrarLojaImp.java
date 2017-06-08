
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.ItemEstoque;
import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.entidades.Venda;
import br.com.distribuidora.persistencia.RepositorioLoja;
import br.com.distribuidora.persistencia.RepositorioUsuario;
import br.com.distribuidora.persistencia.RepositorioVenda;
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
public class CadastrarLojaImp implements CadastrarLoja {
    
    private static final Logger log = LoggerFactory.getLogger(CadastrarLojaImp.class);

    @Autowired
    private RepositorioLoja repositorioLoja;

    @Autowired
    private RepositorioVenda repositorioVenda;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    @Transactional(rollbackFor = LojaExistenteException.class)
    public void adicionarLoja(Loja loja) throws LojaExistenteException {
        try {
            this.buscarLoja(loja.getCnpj());
            this.log.error("Loja " + loja.getCnpj() + " já existe.");
            
            // ends
            throw new LojaExistenteException("Loja " + loja.getCnpj() + " já existe.");
        } catch (LojaInexistenteException e) {
            this.repositorioLoja.save(loja);
            this.log.info("Loja " + loja.getCnpj() + " cadastrada com sucesso.");
        }
    }

    @Override
    @Transactional(rollbackFor = LojaInexistenteException.class)
    public void removerLoja(String cnpj) throws LojaInexistenteException {
        try {
            Loja loja = this.buscarLoja(cnpj);
            this.repositorioLoja.delete(loja);
            this.log.info("Loja " + loja.getCnpj() + " foi removida.");
        } catch (LojaInexistenteException e) {
            this.log.error("Loja " + cnpj + " não existe, não pode ser removida.");
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = LojaInexistenteException.class)
    public Loja buscarLoja(String cnpj) throws LojaInexistenteException {
        Loja loja = this.repositorioLoja.findByCnpj(cnpj);
        if ((loja == null)) {
            throw new LojaInexistenteException("Loja " + cnpj + " não existe.");
        }
        return loja;
    }

    // Validar venda

    private ItemEstoque getEstoqueDoProduto(Loja loja, Produto produto) {
        for (ItemEstoque item : loja.getEstoque()) {
            if ((item.getProduto().equals(produto))) {
                return item;
            }
        }
        return null;
    }
 
    @Override
    public void vender(Loja loja, Venda venda) throws VendaException {
        try {
            for (Produto produto : venda.getProdutos()) {
                ItemEstoque estoque = this.getEstoqueDoProduto(loja, produto);
                if ((estoque == null)) {
                    throw new VendaException("Produto não existe no estoque.");
                } else if ((estoque.getQuant() <= 0)) {
                    throw new VendaException("Produto não tem estoque");
                }

                // Contabiliza o preço do produto... não remover
                venda.setValor(venda.getValor() + produto.getPreco());
            }
            
            // Persiste venda
            this.repositorioVenda.save(venda);
            
            // Persiste usuário
            venda.getUsuario().getVendas().add(venda);
            this.repositorioUsuario.save(venda.getUsuario());
            
            // Persiste loja
            loja.getVendas().add(venda);
            this.repositorioLoja.save(loja);
            
            log.info("Venda " + venda.getId() + " realizada, caixa: " + venda.getValor());
        } catch (VendaException e) {
            log.error(e.getMessage());
        }
    }
    
}
