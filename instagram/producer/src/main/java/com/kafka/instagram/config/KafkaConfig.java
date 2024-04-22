package com.kafka.instagram.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.kafka.instagram.constant.AppConstants.USER_ACTIVITY_TOPIC;

@Configuration
public class KafkaConfig {

//    @Bean
//    public ProducerFactory<String, Post> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.kafka.instagram.config.PostSerializer");
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean(name = "followEventKafkaTemplate")
//    public KafkaTemplate<String, Post> followEventKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean(name = "likeEventKafkaTemplate")
//    public KafkaTemplate<String, Post> likeEventKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean(name = "commentEventKafkaTemplate")
//    public KafkaTemplate<String, Post> commentEventKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean(name = "messageEventKafkaTemplate")
//    public KafkaTemplate<String, Post> messageEventKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean(name = "aggregatedNotificationsKafkaTemplate")
//    public KafkaTemplate<String, Post> aggregatedNotificationsKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(USER_ACTIVITY_TOPIC)
                .partitions(4)
                .build();
    }


}
