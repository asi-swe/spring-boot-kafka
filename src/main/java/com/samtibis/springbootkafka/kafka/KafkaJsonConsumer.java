package com.samtibis.springbootkafka.kafka;

import com.samtibis.springbootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(groupId = "my-group",topics = "topic-json")
    public void consume(User user) {
        LOGGER.info(String.format("Message received -> %s", user.toString()));
    }

}
