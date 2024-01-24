package com.ldp.receiver.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(topics = "message-TOPIC",groupId = "user-group")
    public  void getMessage(String message) {
        System.out.println("c1"+message);
    }
    @KafkaListener(topics = "message-TOPIC",groupId = "user-group")
    public  void getMessage1(String message) {
        System.out.println("c2"+message);
    }
    @KafkaListener(topics = "message-TOPIC",groupId = "user-group")
    public  void getMessage2(String message)  {
        System.out.println("c3"+message);
    }

}
