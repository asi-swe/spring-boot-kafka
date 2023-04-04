package com.samtibis.springbootkafka.controller;

import com.samtibis.springbootkafka.kafka.KafkaConsumer;
import com.samtibis.springbootkafka.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @GetMapping("/write-to-kafka")
    public ResponseEntity<String> writeToKafka(@RequestParam("message") String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message sent to the topic!");
    }


}
