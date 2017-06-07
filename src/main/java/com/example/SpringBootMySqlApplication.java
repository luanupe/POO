package com.example;

import java.util.Date;
import java.util.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller

public class SpringBootMySqlApplication {

   
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "HELLO WORLD!";
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMySqlApplication.class, args);
                //SpringApplication.run(SampleAmqpSimpleApplication.class, args);
	}
}
