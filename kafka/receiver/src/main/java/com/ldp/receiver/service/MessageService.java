package com.ldp.receiver.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(topics = "message-stage-3-TOPIC", groupId = "user-group")
    public void getMessage(String message) {
        System.out.println("c1" + message);
    }

}
