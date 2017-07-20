package br.com.distribuidora.controllers;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.negocios.CadastrarLoja;
import br.com.distribuidora.negocios.CadastrarLojaImp;
import br.com.distribuidora.negocios.CadastrarUsuario;
import br.com.distribuidora.negocios.CadastrarUsuarioImp;
import br.com.distribuidora.negocios.UsuarioInexistenteException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LAF
 */
@Controller
public class UsuarioController {

    @Autowired
    private CadastrarUsuario negocioUsuario;

    @Autowired
    private CadastrarLoja negocioLoja;

    public UsuarioController() {
        this.negocioUsuario = new CadastrarUsuarioImp();
        this.negocioLoja = new CadastrarLojaImp();
    }

    @RequestMapping("/usuarios")
    public String listar(Model model) {
        Usuario usuario = LoginController.getUsuario();
        if ((usuario == null)) {
            return "redirect:/login";
        }
        
        List<Usuario> usuarios = this.negocioUsuario.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", usuario);
        return "/usuario/listar";
    }

    @RequestMapping("/usuario")
    public String perfil(Model model) {
        Usuario usuario = LoginController.getUsuario();
        if ((usuario == null)) {
            return "redirect:/login";
        }

        return this.pegarPerfil(usuario, model);
    }

    @RequestMapping(value = "/usuario/perfil/{id}")
    public String perfil(@PathVariable String id, Model model) {
        try {
            Usuario usuario = this.negocioUsuario.buscarUsuario(id);
            return this.pegarPerfil(usuario, model);
        } catch (UsuarioInexistenteException ex) {

        }

        return "redirect:/usuario";
    }

    private String pegarPerfil(Usuario usuario, Model model) {
        List<Loja> minhasLojas = new ArrayList<Loja>();
        Iterable<Loja> todasLojas = this.negocioLoja.buscar();

        // Pega lojas do usuário
        for (Loja loja : todasLojas) {
            for (Usuario funcionario : loja.getUsuarios()) {
                if ((funcionario.getCpf().equals(usuario.getCpf()))) {
                    minhasLojas.add(loja);
                }
            }
        }

        // Adiciona os elementos da página
        model.addAttribute("lojas", minhasLojas);
        model.addAttribute("usuario", usuario);
        return "/usuario/exibir";
    }

}
