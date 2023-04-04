package com.samtibis.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(groupId = "my-group",topics = "topic1")
    public void listen(String in) {
        LOGGER.info(String.format("Message received -> %s", in));
    }

}
