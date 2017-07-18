package br.com.distribuidora.queues;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author LAF
 */
public class QueueLoja {
    
    public final static String SFG_MESSAGE_QUEUE = "messagem-loja";

    public QueueLoja() {
        System.out.println("Construiu Loja!!!!!!!!!!!!!");
    }
    
    @Bean
    Queue queue() {
        return new Queue(SFG_MESSAGE_QUEUE, false);
    }
    
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }
    
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(SFG_MESSAGE_QUEUE);
    }
    
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(SFG_MESSAGE_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }
    
    @Bean
    MessageListenerAdapter listenerAdapter(QueueEventoListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    
}
