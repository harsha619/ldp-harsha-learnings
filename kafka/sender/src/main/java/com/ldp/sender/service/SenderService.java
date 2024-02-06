package com.ldp.sender.service;

import com.ldp.sender.DTO.Sender;
import com.ldp.sender.constant.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Qualifier("StockPriceProducer")
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate1;

    @Autowired
    @Qualifier("NewsFeedProducer")
    private KafkaTemplate<String, Object> kafkaTemplate2;

    @Autowired
    @Qualifier("PortfolioUpdateProducer")
    private KafkaTemplate<String, Object> kafkaTemplate3;

    @Autowired
    @Qualifier("AnalyticsProducer")
    private KafkaTemplate<String, Object> kafkaTemplate4;

    @Autowired
    @Qualifier("AlertsProducer")
    private KafkaTemplate<String, Object> kafkaTemplate5;

    public boolean sendMessage(Sender sender, int producerId) throws InterruptedException {
        switch (producerId) {
            case 1:
                kafkaTemplate1.send(AppConstants.FIRST_TOPIC, sender);
                break;
            case 2:
                kafkaTemplate2.send(AppConstants.SECOND_TOPIC, sender);
                break;
            case 3:
                kafkaTemplate3.send(AppConstants.THIRD_TOPIC, sender);
                break;
            case 4:
                kafkaTemplate4.send(AppConstants.FOURTH_TOPIC, sender);
                break;
            case 5:
                kafkaTemplate5.send(AppConstants.FIFTH_TOPIC, sender);
                break;
            default:
                throw new IllegalArgumentException("Invalid producerId: " + producerId);
        }
        return true;
    }
}
