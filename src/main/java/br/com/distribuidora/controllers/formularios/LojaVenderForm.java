package br.com.distribuidora.controllers.formularios;

import br.com.distribuidora.entidades.Venda;
import java.util.Date;

/**
 *
 * @author LAF
 */
public class LojaVenderForm {

    private String loja;
    private String cliente;
    private String tipoPagamento;

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Venda getVenda() {
        Venda venda = new Venda();
        venda.setDataVenda(new Date());
        venda.setDataEntrega(new Date());
        venda.setValor(0F);
        venda.setTipoPagamento(tipoPagamento);
        return venda;
    }

}
