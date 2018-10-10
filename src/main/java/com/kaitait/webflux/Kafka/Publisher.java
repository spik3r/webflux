package com.kaitait.webflux.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@Slf4j
@RestController
@RequestMapping("kafka")
public class Publisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "test";
    private final CountDownLatch latch = new CountDownLatch(3);

    @GetMapping("/publish/{msg}")
    public String publish(@PathVariable("msg") final String msg) {

//        kafkaTemplate.send(TOPIC, msg);
        this.kafkaTemplate.send(TOPIC, "foo1");
        this.kafkaTemplate.send(TOPIC, "foo2");
        this.kafkaTemplate.send(TOPIC, "foo3");


    return "Success!";
    }


    @KafkaListener(topics = TOPIC)
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info(cr.toString());
        latch.countDown();
    }

    @GetMapping("/messages")
    public String messages() {

    return "Success!";
    }
}
