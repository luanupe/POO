package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.AutenticarForm;
import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.negocios.CadastrarUsuario;
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

    @RequestMapping("/login")
    public String login(Model model) {
        if ((LoginController.usuario != null)) {
            return "redirect:/usuario";
        }
        
        model.addAttribute("formulario", new AutenticarForm());
        return "/login/autenticarform";
    }

    @RequestMapping(value = "/login/autenticar", method = RequestMethod.POST)
    public String autenticar(@Valid AutenticarForm productForm, BindingResult bindingResult) {
        try {
            if ((bindingResult.hasErrors()) == false) {
                LoginController.usuario = this.negocioUsuario.buscarUsuario(productForm.getLogin());
                return "redirect:/loja";
            }
        } catch (UsuarioInexistenteException ex) {

        }
        
        return "/login/autenticarform";
    }
    
}
