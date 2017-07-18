package com.example;

import br.com.distribuidora.entidades.Loja;
import br.com.distribuidora.persistencia.RepositorioLoja;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
//@EnableJpaRepositories("br.com.distribuidora.persistencia")
//@ComponentScan("br.com.distribuidora.entidades")
//@EntityScan("br.com.distribuidora.entidades")
public class SpringBootMySqlApplication {
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/login";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMySqlApplication.class, args);
    }
}
