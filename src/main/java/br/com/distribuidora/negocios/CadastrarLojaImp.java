
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.persistencia.RepositorioLoja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patricia
 */
@Service
public class CadastrarLojaImp implements CadastrarLoja {

     @Autowired
    private RepositorioLoja repositorioLoja;
    
    @Override
    @Transactional(rollbackFor = LojaExistenteException.class)
    public void adicionarLoja(Loja loja) throws LojaExistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerLoja(String cnpj) throws LojaInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loja buscarLoja(String cnpj) throws LojaInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
