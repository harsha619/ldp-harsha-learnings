package com.kafka.instagram.service;

import com.kafka.instagram.constant.AppConstants;
import com.kafka.instagram.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InstagramConsumer {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public InstagramConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @KafkaListener(
            topics = AppConstants.USER_ACTIVITY_TOPIC,
            groupId = "user",
            topicPartitions = {
                    @TopicPartition(
                            topic = AppConstants.USER_ACTIVITY_TOPIC,
                            partitions = {"0"}
                    )
            }
    )
    public void StockPriceAnalyzer(Post post) {
        System.out.println("follow" + post.getFollowers());
    }

    @KafkaListener(
            topicPartitions = {
                    @TopicPartition(
                            topic = AppConstants.USER_ACTIVITY_TOPIC,
                            partitions = {"1"}
                    )
            },
            groupId = "user",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void NewsFeedProcessor(Post message) {
        System.out.println("like" + message);
    }

    @KafkaListener(
            topicPartitions = {
                    @TopicPartition(
                            topic = AppConstants.USER_ACTIVITY_TOPIC,
                            partitions = {"2"}
                    )
            },
            groupId = "user",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void commentEvent(Post message) {
        System.out.println("comment" + message);
    }

    @KafkaListener(
            topicPartitions = {
                    @TopicPartition(
                            topic = AppConstants.USER_ACTIVITY_TOPIC,
                            partitions = {"3"}
                    )
            },
            groupId = "user",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void shareEvent(Post message) {
        System.out.println("share" + message.getId());
    }

    @KafkaListener(topics = AppConstants.USER_ACTIVITY_TOPIC, groupId = "user-alerts")
    public void HistoricalDataArchiver(Post consumerPost) {

        System.out.println("notication"+consumerPost.getComments());
    }


}
