package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@ComponentScan("br.com.distribuidora")
@EnableJpaRepositories("br.com.distribuidora.persistencia")
@EntityScan("br.com.distribuidora.entidades")

public class SpringBootMySqlApplication {
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/login";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMySqlApplication.class, args);
    }
}
