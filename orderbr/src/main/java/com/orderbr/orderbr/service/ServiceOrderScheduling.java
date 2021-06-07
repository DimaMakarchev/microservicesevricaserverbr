package com.orderbr.orderbr.service;

import com.orderbr.orderbr.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;


@EnableScheduling
@EnableBinding(Source.class)
@AllArgsConstructor
public class ServiceOrderScheduling {

    private final Source source;

    @Scheduled(fixedRate = 3000)

    public void methodScheduled() {
        Random random = new Random();
        Order order = new Order(random.nextInt(10), "BRO", "BRO");
        System.out.println(order);
        source.output().send(MessageBuilder.withPayload(order).build());
    }
}
