package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.LojaCriarForm;
import br.com.distribuidora.controllers.formularios.LojaVenderForm;
import br.com.distribuidora.entidades.Cliente;
import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.entidades.Venda;
import br.com.distribuidora.negocios.CadastrarCliente;
import br.com.distribuidora.negocios.CadastrarClienteImp;
import br.com.distribuidora.negocios.CadastrarLoja;
import br.com.distribuidora.negocios.CadastrarLojaImp;
import br.com.distribuidora.negocios.CadastrarUsuario;
import br.com.distribuidora.negocios.CadastrarUsuarioImp;
import br.com.distribuidora.negocios.CadastrarVenda;
import br.com.distribuidora.negocios.CadastrarVendaImp;
import br.com.distribuidora.negocios.LojaExistenteException;
import br.com.distribuidora.negocios.LojaInexistenteException;
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

    @Autowired
    private CadastrarVenda negocioVenda;

    @Autowired
    private CadastrarCliente negocioCliente;

    public LojaController() {
        this.negocioUsuario = new CadastrarUsuarioImp();
        this.negocioLoja = new CadastrarLojaImp();
        this.negocioVenda = new CadastrarVendaImp();
        this.negocioCliente = new CadastrarClienteImp();
    }

    @RequestMapping("/lojas")
    public String listar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        Iterable<Loja> lojas = this.negocioLoja.buscar();
        model.addAttribute("lojas", lojas);
        return "/loja/listar";
    }

    @RequestMapping("/loja/criar")
    public String cadastrar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        model.addAttribute("cadastrarForm", new LojaCriarForm());
        return "/loja/cadastrar";
    }

    @RequestMapping(value = "/loja/criar/validar", method = RequestMethod.POST)
    public String cadastrar(@Valid LojaCriarForm criarLojaForm, BindingResult bindingResult) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Loja loja = criarLojaForm.getLoja();
            loja.getUsuarios().add(LoginController.getUsuario());
            this.negocioLoja.adicionarLoja(loja);
            return "redirect:/loja/detalhe/" + loja.getCnpj();
        } catch (LojaExistenteException ex1) {
            
        }
        return "redirect:/loja/cadastrar";
    }

    @RequestMapping(value = "/loja/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Loja loja = this.negocioLoja.buscarLoja(id);
            model.addAttribute("loja", loja);
            model.addAttribute("venderForm", new LojaVenderForm());
        } catch (LojaInexistenteException ex) {

        }
        return "/loja/modificar";
    }

    @RequestMapping("/loja/detalhe/{id}")
    public String detalhe(@PathVariable String id, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            model.addAttribute("loja", this.negocioLoja.buscarLoja(id));
            model.addAttribute("clientes", this.negocioCliente.listarCliente());
            model.addAttribute("venderForm", new LojaVenderForm());
        } catch (LojaInexistenteException ex) {

        }
        return "/loja/exibir";
    }

    /*  */
    
    @RequestMapping(value = "/loja/vender/{id}", method = RequestMethod.POST)
    public String vender(@PathVariable String id, @Valid LojaVenderForm lojaVenderForm, BindingResult bindingResult, Model model) {
        Usuario usuario = LoginController.getUsuario();
        if ((usuario == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Cliente cliente = this.negocioCliente.buscarCliente(lojaVenderForm.getCliente());
            Loja loja = this.negocioLoja.buscarLoja(id);
            
            Venda venda = lojaVenderForm.getVenda();
            venda.setUsuario(usuario);
            venda.setCliente(cliente);
            this.negocioVenda.adicionarVenda(venda);
            
            cliente.getVendas().add(venda);
            loja.getVendas().add(venda);
            
            
            
            return "redirect:/venda/editar/" + venda.getId();
        } catch (Exception ex) {
            
        }
        return "redirect:/loja/detalhe/" + id;
    }

}
