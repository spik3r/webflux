package com.kaitait.webflux.controller;

import com.kaitait.webflux.GreetingWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class GreetingController {

    @Autowired
    private GreetingWebClient greetingWebClient;

    // Tweets are Sent to the client as Server Sent Events
    @GetMapping(value = "/greeting", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String foo() {
        return greetingWebClient.getResult();
    }
}
