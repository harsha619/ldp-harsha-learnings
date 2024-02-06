package com.ldp.sender.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class KafkaConfig {
    @Value("${kafka.topics}")
    private String[] topics;

    @Bean
    public ProducerFactory<String, Object> producerFactory1() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.ldp.sender.config.CustomSerializer");

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "StockPriceProducer")
    public KafkaTemplate<String, Object> kafkaTemplate1() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean(name = "NewsFeedProducer")
    public KafkaTemplate<String, Object> kafkaTemplate2() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean(name = "PortfolioUpdateProducer")
    public KafkaTemplate<String, Object> kafkaTemplate3() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean(name = "AnalyticsProducer")
    public KafkaTemplate<String, Object> kafkaTemplate4() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean(name = "AlertsProducer")
    public KafkaTemplate<String, Object> kafkaTemplate5() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean
    public List<NewTopic> kafkaTopics() {
        List<NewTopic> newTopics = new ArrayList<>();
        for (String topicName : topics) {
            newTopics.add(new NewTopic(topicName, 10, (short) 2));
            System.out.println("topic created.....");
        }
        return newTopics;
    }

}


