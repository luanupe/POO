package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Venda;
import br.com.distribuidora.persistencia.RepositorioVenda;
import java.util.ArrayList;
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
public class CadastrarVendaImp implements CadastrarVenda{

    private static final Logger log = LoggerFactory.getLogger(CadastrarClienteImp.class);
    
    @Autowired
    private RepositorioVenda repositorioVenda;
    
   
     @Override
    public List<Venda> listarVenda() {
            
            List<Venda> vendas = (List<Venda>) repositorioVenda.findAll();
            List<Venda> listaDeVendas = new ArrayList<Venda>();
            
            for(int i=0; i<vendas.size(); i++){
            
           listaDeVendas.add(vendas.get(i));
            
            }
            
        return listaDeVendas;

    }

    @Override
    @Transactional(rollbackFor = VendaInexistenteException.class)
     public Venda buscarVenda(Long id) throws VendaInexistenteException {
        Venda venda = this.repositorioVenda.findById(id);
        if ((venda == null)) {
            throw new VendaInexistenteException("Venda " + id + " não existe.");
        }
        return venda;
    }
    
}
