package br.com.distribuidora.controllers;

import br.com.distribuidora.controllers.formularios.ProdutoCadastrarForm;
import br.com.distribuidora.controllers.formularios.ProdutoBuscarForm;
import br.com.distribuidora.entidades.Produto;
import br.com.distribuidora.negocios.CadastrarProduto;
import br.com.distribuidora.negocios.CadastrarProdutoImp;
import br.com.distribuidora.negocios.ProdutoExistenteException;
import br.com.distribuidora.negocios.ProdutoInexistenteException;
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
public class ProdutoController {

    @Autowired
    private CadastrarProduto negocioProduto;

    public ProdutoController() {
        this.negocioProduto = new CadastrarProdutoImp();
    }

    @RequestMapping("/produtos")
    public String listar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }
        
        /* */
        
        List<Produto> produtos = this.negocioProduto.listarProduto();
        model.addAttribute("produtos", produtos);
        model.addAttribute("produtoForm", new ProdutoBuscarForm());
        return "/produto/listar";
    }
    
    @RequestMapping(value = "/produto/buscar", method = RequestMethod.POST)
    public String cadastrar(@Valid ProdutoBuscarForm produtoBuscarForm, BindingResult bindingResult) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }

        /* */

        if ((produtoBuscarForm.getCodigoBarra() != null)) {
            if ((produtoBuscarForm.getCodigoBarra().isEmpty() == false)) {
                return "redirect:/produto/editar/" + produtoBuscarForm.getCodigoBarra();
            }
        }
        return "redirect:/produtos";
    }

    @RequestMapping("/produto/criar")
    public String cadastrar(Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }
        
        /* */
        
        model.addAttribute("cadastrarForm", new ProdutoCadastrarForm());
        return "/produto/cadastrar";
    }

    @RequestMapping(value = "/produto/criar/validar", method = RequestMethod.POST)
    public String cadastrar(@Valid ProdutoCadastrarForm cadastrarProdutoForm, BindingResult bindingResult) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }
        
        /* */
        
        try {
            Produto produto = cadastrarProdutoForm.getProduto();
            this.negocioProduto.adicionarProduto(produto);
            return "redirect:/produto/editar/" + produto.getCodigoBarra();
        } catch (ProdutoExistenteException e) {
            
        }
        return "/produto/cadastrar";
    }

    @RequestMapping(value = "/produto/editar/{id}")
    public String exibir(@PathVariable String id, Model model) {
        if ((LoginController.getUsuario() == null)) {
            return "redirect:/login";
        }
        
        /* */
        
        try {
            Produto produto = this.negocioProduto.buscarProduto(id);
            model.addAttribute("produto", produto);
            model.addAttribute("editarForm", new ProdutoCadastrarForm());
        } catch (ProdutoInexistenteException ex) {
            
        }
        return "/produto/exibir";
    }

}
