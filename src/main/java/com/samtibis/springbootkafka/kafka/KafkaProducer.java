package com.samtibis.springbootkafka.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public record KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    public void publishMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("topic1", message);
    }
}
