package com.ldp.sender.service;

import com.ldp.sender.constant.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public  boolean booleanSendMessage(String message) throws InterruptedException {
            kafkaTemplate.send(AppConstants.MESSAGE_TOPIC, message);
         return  true;
    }
}
