package com.kaitait.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class GreetingRouter {

    @Autowired
    private GreetingHandler greetingHandler;

    // Tweets are Sent to the client as Server Sent Events
    @GetMapping(value = "/iwantatroll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> getTrololo() {
        log.info("------------------------------------");
        log.info("into getTrololo");
        Mono<String> v = greetingHandler.toTroll();
        log.info("after trololo");

        return v;
    }
}
