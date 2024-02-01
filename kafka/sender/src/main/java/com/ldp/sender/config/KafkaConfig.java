package com.ldp.sender.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.ldp.sender.constant.AppConstants.MESSAGE_TOPIC;

@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(MESSAGE_TOPIC)
                .partitions(10)
                .build();
    }
}
