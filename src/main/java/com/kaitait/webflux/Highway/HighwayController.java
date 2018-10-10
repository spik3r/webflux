package com.kaitait.webflux.Highway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HighwayController {

    @Autowired
    private HighwayTraffic highwayTraffic;

    // Tweets are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/traffic", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Vehicle> streamTraffic() {
        return highwayTraffic.flowTraffic();
    }
}
