package com.samtibis.springbootkafka.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    public void publishMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(topicName, message);
    }
}
