package com.ldp.receiver.service;

import com.ldp.receiver.DTO.Sender;
import com.ldp.receiver.constants.AppConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(topics = "first-topic",groupId = "c1")
    public  void StockPriceAnalyzer(ConsumerRecord<String, Sender> record) {
        System.out.println("c1"+record.value().getClass());
    }

    @KafkaListener(topics = AppConstants.SECOND_TOPIC,groupId = "c2")
    public  void NewsFeedProcessor(Sender message) {
        System.out.println("c2"+message.getMessage());
    }
    @KafkaListener(topics = AppConstants.THIRD_TOPIC,groupId = "c3")
    public  void PortfolioUpdater(String message)  {
        System.out.println("c3"+message);
    }
    @KafkaListener(topics = AppConstants.FOURTH_TOPIC,groupId = "c4")
    public  void AlertsNotifier(String message)  {
        System.out.println("c4"+message);
    }
    @KafkaListener(topics = AppConstants.FIFTH_TOPIC,groupId = "c5")
    public  void HistoricalDataArchiver(ConsumerRecord<String, Sender> record)  {
        System.out.println("c5"+record.value().getMessage());
    }
}
