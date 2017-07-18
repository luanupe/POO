package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.AutenticarForm;
import br.com.distribuidora.entidades.Usuario;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/login")
    public String login(Model model) {
        if ((LoginController.usuario != null)) {
            return "redirect:/loja";
        }
        
        // TODO model.addAtributte(...)
        return "/login/autenticarform";
    }

    @RequestMapping(value = "/login/autenticar", method = RequestMethod.POST)
    public String autenticar(@Valid AutenticarForm productForm, BindingResult bindingResult){
        if ((bindingResult.hasErrors())) {
            return "/login/autenticarform";
        }
        
        // Verifica login e senha
        Usuario autenticado = null;
        
        if ((autenticado == null)) {
            return "/login/autenticarform";
        }
        
        LoginController.usuario = autenticado;
        return "redirect:/loja";
    }
    
}
