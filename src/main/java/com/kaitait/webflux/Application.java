package com.kaitait.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        GreetingWebClient gwc = new GreetingWebClient();
//        System.out.println(gwc.getResult());
    }
}
