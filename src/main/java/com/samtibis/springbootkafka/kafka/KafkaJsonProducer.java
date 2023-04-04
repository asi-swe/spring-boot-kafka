package com.samtibis.springbootkafka.kafka;

import com.samtibis.springbootkafka.payload.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {

        LOGGER.info(String.format("Message sent: %s", user.toString()));

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "topic-json")
                .build();
        kafkaTemplate.send(message);
    }

}
