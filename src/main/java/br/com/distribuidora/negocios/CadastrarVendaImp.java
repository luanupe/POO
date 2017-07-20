package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.entidades.Venda;
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
 * @modified Luan
 */
@Service
public class CadastrarVendaImp implements CadastrarVenda {

    private static final Logger log = LoggerFactory.getLogger(CadastrarClienteImp.class);

    @Autowired
    private RepositorioVenda repositorioVenda;
    
    @Override
    @Transactional(rollbackFor = VendaExistenteException.class)
    public void adicionarVenda(Venda venda) throws VendaExistenteException {
        try {
            this.buscarVenda(venda.getId());
            throw new VendaExistenteException("Não foi possível realizar essa venda, tente novamente.");
        } catch (VendaInexistenteException e) {
            this.repositorioVenda.save(venda);
        }
    }
    
    @Override
    @Transactional(rollbackFor = VendaException.class)
    public void adicionarProduto(Venda venda, Produto produto) throws VendaException {
        for (Produto carrinho : venda.getProdutos()) {
            if ((carrinho.getCodigoBarra().equals(produto.getCodigoBarra()))) {
                throw new VendaException("Esse produto já está no carrinho");
            }
        }
        
        venda.getProdutos().add(produto);
        venda.setValor(venda.getValor() + produto.getPreco());
        this.repositorioVenda.save(venda);
    }
    
    @Override
    @Transactional(rollbackFor = VendaException.class)
    public void removerProduto(Venda venda, Produto produto) throws VendaException {
        for (Produto carrinho : venda.getProdutos()) {
            if ((carrinho.getCodigoBarra().equals(produto.getCodigoBarra()))) {
                venda.getProdutos().remove(carrinho);
                venda.setValor(venda.getValor() - carrinho.getPreco());
                this.repositorioVenda.save(venda);
                
                return;// Para o for
            }
        }
        throw new VendaException("Esse produto não está no carrinho.");
    }

    @Override
    public List<Venda> listarVenda() {
        return (List<Venda>) repositorioVenda.findAll();
    }

    @Override
    @Transactional(rollbackFor = VendaInexistenteException.class)
    public Venda buscarVenda(Long id) throws VendaInexistenteException {
        if ((id == null)) {
            throw new VendaInexistenteException("Não é possível buscar um venda de ID nulo.");
        }
        
        Venda venda = this.repositorioVenda.findById(id);
        if ((venda == null)) {
            throw new VendaInexistenteException("Venda " + id + " não existe.");
        }
        return venda;
    }

}
