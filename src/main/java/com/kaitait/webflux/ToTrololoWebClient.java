package com.kaitait.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ToTrololoWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = client.get()
            .uri("/trololo")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public Mono<ClientResponse> getResult() {
        return result;
    }
}