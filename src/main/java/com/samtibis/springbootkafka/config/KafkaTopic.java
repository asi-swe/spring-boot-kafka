package com.samtibis.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                //.partitions(3)
                //.replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicForJson() {
        return TopicBuilder.name("topic-json")
                //.partitions(3)
                //.replicas(1)
                .build();
    }

}
