package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.AutenticarForm;
import br.com.distribuidora.controllers.formularios.CriarLojaForm;
import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Usuario;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LAF
 */
@Controller
public class LojaController {

    @RequestMapping("/loja/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("formulario", new CriarLojaForm());
        return "loja/lojaform";
    }
    
    @RequestMapping(value = "/loja/cadastrar", method = RequestMethod.POST)
    public String validar(@Valid CriarLojaForm criarLojaForm, BindingResult bindingResult) {
        if ((bindingResult.hasErrors())) {
            return "loja/lojaform";
        }
        
        Usuario usuario = new Usuario();
        usuario.setNome(criarLojaForm.getLogin());
        /*
         * Criar objeto Usuario
         * Criar Objeto Loja
         * persistir Usuario
         * loja.getUsuarios().add(usuario);
         * loja.salvar();
        */
        
        Loja loja = null;
        
        
        return "redirect:/loja/detalhe/" + loja.getId();
    }

    @RequestMapping("/loja/detalhe/{id}")
    public String detalhe(@PathVariable String id, Model model) {
        Loja loja = null; // Pega pelo id
        model.addAttribute("loja", loja);
        return "loja/exibir";
    }

}
