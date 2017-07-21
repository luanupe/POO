package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.VenderFormulario;
import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.entidades.Venda;
import br.com.distribuidora.negocios.CadastrarProduto;
import br.com.distribuidora.negocios.CadastrarProdutoImp;
import br.com.distribuidora.negocios.CadastrarVenda;
import br.com.distribuidora.negocios.CadastrarVendaImp;
import br.com.distribuidora.negocios.VendaInexistenteException;
import java.util.ArrayList;
import java.util.List;
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
public class VendaController {

    @Autowired
    private CadastrarVenda negocioVenda;
    
    @Autowired
    private CadastrarProduto negocioProduto;

    public VendaController() {
        this.negocioVenda = new CadastrarVendaImp();
        this.negocioProduto = new CadastrarProdutoImp();
    }

    @RequestMapping("/vendas")
    public String listar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        List<Venda> vendas = this.negocioVenda.listarVenda();
        model.addAttribute("vendas", vendas);
        return "venda/listar";
    }
    
    @RequestMapping(value = "/venda/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            List<Produto> produtos = this.negocioProduto.listarProduto();
            List<Produto> disponiveis = new ArrayList<Produto>(produtos);
            Venda venda = this.negocioVenda.buscarVenda(id);
            
            for (Produto estoque : produtos) {
                for (Produto carrinho : venda.getProdutos()) {
                    if ((estoque.getId().equals(carrinho.getId()))) {
                        disponiveis.remove(estoque);
                    }
                }
            }
            
            model.addAttribute("venda", venda);
            model.addAttribute("produtos", disponiveis);
            model.addAttribute("venderForm", new VenderFormulario());
        } catch (VendaInexistenteException ex) {
            
        }
        return "/venda/alterar";
    }
    
    @RequestMapping(value = "/venda/adicionar/{id}", method = RequestMethod.POST)
    public String adicionar(@PathVariable Long id, @Valid VenderFormulario venderForm, BindingResult bindingResult) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Venda venda = this.negocioVenda.buscarVenda(id);
            Produto produto = this.negocioProduto.buscarProduto(venderForm.getProduto());
            this.negocioVenda.adicionarProduto(venda, produto);
        } catch (Exception e) {
            
        }
        return "redirect:/venda/editar/" + id;
    }
    
    @RequestMapping(value = "/venda/remover/{id}/{remover}")
    public String remover(@PathVariable Long id, @PathVariable String remover, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Venda venda = this.negocioVenda.buscarVenda(id);
            Produto produto = this.negocioProduto.buscarProduto(remover);
            this.negocioVenda.removerProduto(venda, produto);
        } catch (Exception e) {
            
        }
        return "redirect:/venda/editar/" + id;
    }
    
    @RequestMapping(value = "/venda/checkout/{id}")
    public String checkout(@PathVariable Long id, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        try {
            Venda venda = this.negocioVenda.buscarVenda(id);
            venda.setCheckout(true);
            this.negocioVenda.atualizarVenda(venda);
        } catch (Exception e) {
            
        }
        return "redirect:/venda/editar/" + id;
    }

}
