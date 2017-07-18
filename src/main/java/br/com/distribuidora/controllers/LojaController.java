package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.AutenticarForm;
import br.com.distribuidora.controllers.formularios.CriarLojaForm;
import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.negocios.CadastrarLoja;
import br.com.distribuidora.negocios.CadastrarUsuario;
import br.com.distribuidora.negocios.LojaInexistenteException;
import br.com.distribuidora.negocios.UsuarioInexistenteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private CadastrarLoja negocioLoja;
    
    @Autowired
    private CadastrarUsuario negocioUsuario;

    @RequestMapping("/loja/")
    public String listar(Model model) {
        Iterable<Loja> lojas = this.negocioLoja.buscar();
        model.addAttribute("lojas", lojas);
        return "loja/listarloja";
    }

    @RequestMapping("/loja/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("formulario", new CriarLojaForm());
        return "loja/cadastrarlojaform";
    }
    
    @RequestMapping(value = "/loja/cadastrar", method = RequestMethod.POST)
    public String validarCadastro(@Valid CriarLojaForm criarLojaForm, BindingResult bindingResult) {
        try {
            this.negocioUsuario.buscarUsuario(criarLojaForm.getCpfUsuario());
        } catch (UsuarioInexistenteException uie) {
            try {
                this.negocioLoja.buscarLoja(criarLojaForm.getCnpjLoja());
            } catch (LojaInexistenteException lie) {
                try {
                    // Persistir usuario
                    this.negocioUsuario.adicionarUsuario(criarLojaForm.getUsuario());

                    // Persistir Loja
                    Loja loja = criarLojaForm.getLoja();
                    this.negocioLoja.adicionarLoja(loja);

                    return "redirect:/loja/detalhe/" + loja.getId();
                } catch (Exception e) {
                    
                }
            }
        }
        
        return "loja/cadastrarlojaform";
    }
    
    @RequestMapping(value = "/loja/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        return null;
    }

    @RequestMapping("/loja/detalhe/{id}")
    public String detalhe(@PathVariable String id, Model model) {
        try {
            Loja loja = this.negocioLoja.buscarLoja(id);
            model.addAttribute("loja", loja);
            return "loja/exibirloja";
        } catch (LojaInexistenteException ex) {
            
        }
        return "redirect:/loja";
    }

}
