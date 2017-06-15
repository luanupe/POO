package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Categoria;
import br.com.distribuidora.persistencia.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patricia
 */
@Service
public class CadastrarCategoriaImp implements CadastrarCategoria {

    @Autowired
    private RepositorioCategoria repositorioCategoria;
    
    @Override
    @Transactional(rollbackFor = CategoriaInexistenteException.class)
    public Categoria buscarCategoria(String nome) throws CategoriaInexistenteException {
    Categoria categoria = this.repositorioCategoria.findByNome(nome);
        if ((categoria == null)) {
            throw new CategoriaInexistenteException("Categoria" + nome + " não existe.");
        }
        return categoria;

    }
    
}
