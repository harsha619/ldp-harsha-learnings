package com.ldp.sender.service;

import com.ldp.sender.constant.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean booleanSendMessage(String message) throws InterruptedException {
        int totalPartitions = 10;
        int messagesPerPartition = 10000;
        System.out.println("into one m");
        for (int partition = 0; partition < totalPartitions; partition++) {
            for (int i = 0; i < messagesPerPartition; i++) {
                System.out.println("one " + "(" + i);
                kafkaTemplate.send(AppConstants.MESSAGE_TOPIC, partition, Integer.toString(partition), "message" + "*" + i);
            }
        }
        return true;
    }

    public boolean booleanSendMessageHalfMillion(String message) throws InterruptedException {
        int totalPartitions = 5;
        int messagesPerPartition = 10000;
        System.out.println("into 0.5 m");
        for (int partition = 0; partition < totalPartitions; partition++) {
            for (int i = 0; i < messagesPerPartition; i++) {
                System.out.println("half" + "(" + i);
                kafkaTemplate.send(AppConstants.MESSAGE_TOPIC, partition, Integer.toString(partition), "message" + "*" + i);
            }
        }
        return true;
    }
}
