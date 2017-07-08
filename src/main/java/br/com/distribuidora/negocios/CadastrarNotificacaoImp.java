package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Encaminhamento;
import br.com.distribuidora.entidades.Evento;
import br.com.distribuidora.entidades.EventoEstoque;
import br.com.distribuidora.entidades.EventoPedido;
import br.com.distribuidora.entidades.ItemEstoque;
import br.com.distribuidora.entidades.Notificacao;
import br.com.distribuidora.entidades.Pedido;
import br.com.distribuidora.entidades.Usuario;
import br.com.distribuidora.persistencia.RepositorioEncaminhamento;
import br.com.distribuidora.persistencia.RepositorioEvento;
import br.com.distribuidora.persistencia.RepositorioNotificacao;
import br.com.distribuidora.persistencia.RepositorioUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LAF
 */
@Service
public class CadastrarNotificacaoImp implements CadastrarNotificacao {

    @Autowired
    private RepositorioUsuario repositorioUsario;

    @Autowired
    private RepositorioNotificacao repositorioNotificacao;

    @Autowired
    private RepositorioEncaminhamento repositorioEncaminhamento;

    @Autowired
    private RepositorioEvento repositorioEvento;



    @Transactional(rollbackFor = NotificacaoException.class)
    public Evento criarEvento(Pedido pedido, Usuario responsavel, List<Usuario> subscribers) throws NotificacaoException {
        List<Encaminhamento> encaminhamentos = new ArrayList<Encaminhamento>();
        EventoPedido eventoPedido = new EventoPedido(pedido, responsavel, encaminhamentos, subscribers);
        
        // Salva o novo evento criado
        this.repositorioEvento.save(eventoPedido);
        
        return eventoPedido;
    }

    @Transactional(rollbackFor = NotificacaoException.class)
    public Evento criarEvento(ItemEstoque item, int quantidade, Pedido pedido) throws NotificacaoException {
        List<Encaminhamento> encaminhamentos = new ArrayList<Encaminhamento>();
        List<Usuario> subscribers = this.repositorioUsario.findByFuncao("Estoquista");
        
        if ((subscribers.isEmpty())) {
            throw new NotificacaoException("Não há estoquistas cadastrado para ser notificado.");
        }
        
        // Pessoa aleatória (primeiro da lista)
        Usuario responsavel = subscribers.get(0);
        
        // Cria o evento pedido
        EventoEstoque eventoPedido = new EventoEstoque(item, quantidade, pedido, responsavel, encaminhamentos, subscribers);
        
        // Salva o novo evento criado
        this.repositorioEvento.save(eventoPedido);
        
        return eventoPedido;
    }

    @Override
    @Transactional(rollbackFor = NotificacaoException.class)
    public void adicionarNotificacao(Evento evento) throws NotificacaoException {
        // Notifica os subscribers
        for (Usuario usuario : evento.getSubcribers()) {
            // Pra não notificar 2 vezes seguidas
            if ((usuario != evento.getResponsavel())) {
                Notificacao notificacao = new Notificacao(usuario, false, new Date(), evento);
                this.repositorioNotificacao.save(notificacao);
            }
        }
        
        // Notifica o responsável
        Notificacao notificacao = new Notificacao(evento.getResponsavel(), false, new Date(), evento);
        this.repositorioNotificacao.save(notificacao);
    }

    @Override
    @Transactional(rollbackFor = NotificacaoException.class)
    public void cadastrarEncaminhamento(Evento evento, Encaminhamento encaminhamento) throws NotificacaoException {
        // Insere o encaminhamento no banco de dados
        this.repositorioEncaminhamento.save(encaminhamento);
        
        // Adiciona o encaminhamento pro evento
        evento.getEncaminhamentos().add(encaminhamento);
        this.repositorioEvento.save(evento);
        
        // Renotificar todos pq chegou novo encaminhamento
        this.adicionarNotificacao(evento);
    }

}
