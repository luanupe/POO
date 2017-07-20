package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.persistencia.RepositorioUsuario;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patricia
 * @modified Luan
 */
@Service
@Configurable
public class CadastrarUsuarioImp implements CadastrarUsuario {

    private static final Logger log = LoggerFactory.getLogger(CadastrarUsuarioImp.class);

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    @Transactional(rollbackFor = UsuarioExistenteException.class)
    public void adicionarUsuario(Usuario usuario) throws UsuarioExistenteException {
        try {
            this.buscarUsuario(usuario.getCpf());
            this.log.error("Usuario " + usuario.getCpf() + " já existe.");
            throw new UsuarioExistenteException("Usuario " + usuario.getCpf() + " já existe ,não foi possível cadastrar.");
        } catch (UsuarioInexistenteException e) {
            this.repositorioUsuario.save(usuario);
            this.log.info("Usuário " + usuario.getCpf() + " foi cadastrado com sucesso, admissão: " + usuario.getDataAdmissao());
            
            // TODO Adicionar pra uma loja?
        }
    }

    @Override
    @Transactional(rollbackFor = UsuarioInexistenteException.class)
    public void removerUsuario(String cpf) throws UsuarioInexistenteException {
        try {
            Usuario usuario = this.buscarUsuario(cpf);
            usuario.setDataDemissao(new Date());
            this.repositorioUsuario.save(usuario);
            this.log.info("Usuario " + cpf + " setado como inativo, demissão: " + usuario.getDataDemissao());
            
            // TODO Remover da loja?
        } catch (UsuarioInexistenteException e) {
            this.log.error("Usuario " + cpf + " não existe, não foi possível remover.");
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = UsuarioInexistenteException.class)
    public Usuario buscarUsuario(String cpf) throws UsuarioInexistenteException {
        Usuario usuario = this.repositorioUsuario.findByCpf(cpf);
        if ((usuario == null)) {
            this.log.error("Usuário " + cpf + " não existe, excessão...");
            throw new UsuarioInexistenteException("Usuário " + cpf + " não foi encontrado.");
        }
        return usuario;
    }
    
    @Override
    public List<Usuario> listarUsuario() {
        return (List<Usuario> ) repositorioUsuario.findAll();
    }
}
