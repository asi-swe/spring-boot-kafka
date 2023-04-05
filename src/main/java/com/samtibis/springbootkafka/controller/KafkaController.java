package com.samtibis.springbootkafka.controller;

import com.samtibis.springbootkafka.kafka.KafkaConsumer;
import com.samtibis.springbootkafka.kafka.KafkaJsonProducer;
import com.samtibis.springbootkafka.kafka.KafkaProducer;
import com.samtibis.springbootkafka.payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @GetMapping("/write-to-kafka")
    public ResponseEntity<String> writeToKafka(@RequestParam("message") String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message sent to the topic!");
    }

    @PostMapping("/write-json-to-kafka")
    public ResponseEntity<String> writeJsonToKafka(@RequestBody User user) {
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to the topic!");
    }


}
