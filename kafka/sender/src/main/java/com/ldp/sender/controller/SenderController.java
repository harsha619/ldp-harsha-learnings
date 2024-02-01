package com.ldp.sender.controller;


import com.ldp.sender.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.ldp.sender.constant.AppConstants.MESSAGE_TOPIC;

@RestController
@RequestMapping("/sender/")
public class SenderController {
    @Autowired
    private SenderService senderService;

    @PutMapping("one-million")
    public ResponseEntity sendMessage() throws InterruptedException {
        System.out.println("inro cont");
        senderService.booleanSendMessage("kafka started at service");
        return new ResponseEntity<>(Map.of(MESSAGE_TOPIC, "location updated"), HttpStatus.OK);

    }

    @PutMapping("half-million")
    public ResponseEntity sendMessageHalfMillion() throws InterruptedException {
        System.out.println("inro cont");
        senderService.booleanSendMessageHalfMillion("kafka started at service");
        return new ResponseEntity<>(Map.of(MESSAGE_TOPIC, "location updated"), HttpStatus.OK);

    }
}
