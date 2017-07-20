package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.AutenticarForm;
import br.com.distribuidora.controllers.formularios.CriarUsuarioForm;
import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.negocios.CadastrarUsuario;
import br.com.distribuidora.negocios.CadastrarUsuarioImp;
import br.com.distribuidora.negocios.UsuarioExistenteException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.distribuidora.negocios.UsuarioInexistenteException;

/**
 *
 * @author LAF
 */
@Controller
public class LoginController {

    private static Usuario usuario;

    public static Usuario getUsuario() {
        return LoginController.usuario;
    }

    /* */

    @Autowired
    private CadastrarUsuario negocioUsuario;
    
    public LoginController() {
        this.negocioUsuario = new CadastrarUsuarioImp();
    }

    @RequestMapping("/login")
    public String login(Model model) {
        if ((LoginController.usuario != null)) {
            return "redirect:/usuario";
        }
        
        model.addAttribute("autenticarForm", new AutenticarForm());
        return "/login/autenticar";
    }

    @RequestMapping(value = "/login/autenticar", method = RequestMethod.POST)
    public String login(@Valid AutenticarForm autenticarForm, BindingResult bindingResult) {
        try {
            if ((bindingResult.hasErrors()) == false) {
                LoginController.usuario = this.negocioUsuario.buscarUsuario(autenticarForm.getCpf());
                return "redirect:/usuario";
            }
        } catch (UsuarioInexistenteException ex) {
            return "redirect:/login/criar";
        }
        
        return "/login/autenticar";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        LoginController.usuario = null;
        return "redirect:/login";
    }
    
    /* Cadastro de Usuário */

    @RequestMapping("/login/criar")
    public String cadastrar(Model model) {
        if ((LoginController.getUsuario() != null)) {
            return "redirect:/usuario";  
        }
        
        model.addAttribute("cadastrarForm", new CriarUsuarioForm());
        return "/login/cadastrar";
    }

    @RequestMapping(value = "/login/criar/validar", method = RequestMethod.POST)
    public String cadastrar(@Valid CriarUsuarioForm cadastrarForm, BindingResult bindingResult) {
        try {
            if ((bindingResult.hasErrors()) == false) {
                Usuario usuario = cadastrarForm.getUsuario();
                this.negocioUsuario.adicionarUsuario(usuario);
                LoginController.usuario = usuario;
                return "redirect:/usuario";
            }
        } catch (UsuarioExistenteException ex) {
            return "redirect:/login";
        }
        
        return "/login/cadastrar";
    }
    
}
