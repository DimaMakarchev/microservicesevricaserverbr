package com.storebr.storebr.service;

import com.storebr.storebr.model.Order;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@EnableBinding(Sink.class)
@MessageEndpoint
public class FinishServiceMessages {
    Logger logger = Logger.getLogger(FinishServiceMessages.class.getName());

    @StreamListener(Sink.INPUT)
    void methodMessageEndpointsFinish(Order order) {
        logger.info("BROOOOOOOO => " + order);
    }
}
