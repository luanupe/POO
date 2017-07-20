package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.CriarClienteForm;
import br.com.distribuidora.entidades.Cliente;
import br.com.distribuidora.negocios.CadastrarCliente;
import br.com.distribuidora.negocios.CadastrarClienteImp;
import br.com.distribuidora.negocios.ClienteInexistenteException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.distribuidora.negocios.ClienteExistenteException;

/**
 *
 * @author LAF
 */
@Controller
public class ClienteController {

    @Autowired
    private CadastrarCliente negocioCliente;

    public ClienteController() {
        this.negocioCliente = new CadastrarClienteImp();
    }

    @RequestMapping("/clientes")
    public String listar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        List<Cliente> clientes = this.negocioCliente.listarCliente();
        model.addAttribute("clientes", clientes);
        return "/cliente/listar";
    }

    @RequestMapping(value = "/cliente/perfil/{id}")
    public String perfil(@PathVariable String id, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Cliente cliente = this.negocioCliente.buscarCliente(id);
            model.addAttribute("cliente", cliente);
        } catch (ClienteInexistenteException ex) {
            
        }
        
        return "/cliente/exibir";
    }

    @RequestMapping("/cliente/criar")
    public String cadastrar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        model.addAttribute("cadastrarForm", new CriarClienteForm());
        return "/cliente/cadastrar";
    }
    
    @RequestMapping(value = "/cliente/criar/validar", method = RequestMethod.POST)
    public String cadastrar(@Valid CriarClienteForm criarClienteForm, BindingResult bindingResult) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Cliente cliente = criarClienteForm.getCliente();
            this.negocioCliente.adicionarCliente(cliente);
            return "redirect:/cliente/perfil/" + cliente.getCpfCnpj();
        } catch (ClienteExistenteException ee) {
            
        }
        return "/cliente/cadastrar";
    }

}
