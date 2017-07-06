package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Categoria;
import br.com.distribuidora.persistencia.RepositorioCategoria;
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
public class CadastrarCategoriaImp implements CadastrarCategoria {

    private static final Logger log = LoggerFactory.getLogger(CadastrarLojaImp.class);

    
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional(rollbackFor = CategoriaExistenteException.class)
    public void adicionarCategoria(Categoria categoria) throws CategoriaExistenteException {
         try {
            this.buscarCategoria(categoria.getNome());
         
            this.log.error("Categoria " + categoria.getNome() + " já existe.");
            
            // ends
            throw new CategoriaExistenteException("Categoria " + categoria.getNome() + " já existe.");
                    
        } catch (CategoriaInexistenteException e) {
           
            this.repositorioCategoria.save(categoria);
            this.log.info("Categoria " + categoria.getNome() + " cadastrada com sucesso.");
        }
    }
    
    @Override
    @Transactional(rollbackFor = CategoriaInexistenteException.class)
    public Categoria buscarCategoria(String nome) throws CategoriaInexistenteException {
    Categoria categoria = this.repositorioCategoria.findByNome(nome);
        if ((categoria == null)) {
            throw new CategoriaInexistenteException("Categoria" + nome + " não existe.");
        }
        return categoria;

    }
    
    
    @Override
    @Transactional(rollbackFor = CategoriaInexistenteException.class)
    public void atualizarCategoria(Categoria categoria) throws CategoriaInexistenteException{
        
       Categoria categoriaAntiga = buscarCategoria(categoria.getNome());
       
       categoriaAntiga.setNome(categoria.getNome());
       categoriaAntiga.setQuant(categoria.getQuant());
       //Luan por favor verifique se assim esta correto
       categoriaAntiga.getProdutos().addAll(categoria.getProdutos());
       
       repositorioCategoria.save(categoriaAntiga);
    }
    
    @Override
    public List<Categoria> listarCategoria() {

        return (List<Categoria> ) repositorioCategoria.findAll();

    }
}