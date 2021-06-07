package com.example.bucketservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController

public class MsgController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/msg/{msgId}/{msg}")
    public void sendOrder(@PathVariable("msgId") String msgId, @PathVariable("msg") String msg){
        kafkaTemplate.send("msg", msgId, msg);
    }
}
