package com.ldp.sender.controller;

import com.ldp.sender.DTO.Sender;
import com.ldp.sender.constant.AppConstants;
import com.ldp.sender.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sender/")
public class SenderController {

    private final SenderService senderService;

    @Autowired
    public SenderController(SenderService senderService) {
        this.senderService = senderService;
    }

    @PutMapping("stockPrice")
    public ResponseEntity sendStockPriceMessage() throws InterruptedException {
        Sender sender = new Sender();
        sender.setPrice(12);
        senderService.sendMessage(sender, 1);
        return new ResponseEntity<>(Map.of(AppConstants.FIRST_TOPIC, "location updated stockPrice"), HttpStatus.OK);
    }

    @PutMapping("newsFeed")
    public ResponseEntity sendNewsFeedMessage() throws InterruptedException {
        Sender sender = new Sender();
        sender.setNews("new item is added");
        senderService.sendMessage(sender, 2);
        return new ResponseEntity<>(Map.of(AppConstants.SECOND_TOPIC, "location updated newsFeed"), HttpStatus.OK);
    }

    @PutMapping("portfolioUpdate")
    public ResponseEntity sendPortfolioUpdateMessage() throws InterruptedException {
        Sender sender = new Sender();
        sender.setPrice(12);
        senderService.sendMessage(sender, 3);
        return new ResponseEntity<>(Map.of(AppConstants.THIRD_TOPIC, "location updated portfolioUpdate"), HttpStatus.OK);
    }

    @PutMapping("analytics")
    public ResponseEntity sendAnalyticsMessage() throws InterruptedException {
        Sender sender = new Sender();
        sender.setAnalytics("incerese the item price");
        senderService.sendMessage(sender, 4);
        return new ResponseEntity<>(Map.of(AppConstants.FOURTH_TOPIC, "location updated analytics"), HttpStatus.OK);
    }

    @PutMapping("alerts")
    public ResponseEntity sendAlertsMessage() throws InterruptedException {
        Sender sender = new Sender();
        sender.setAlert("Items out of stock");
        senderService.sendMessage(sender, 5);
        return new ResponseEntity<>(Map.of(AppConstants.FIFTH_TOPIC, "location updated alerts"), HttpStatus.OK);
    }
}
