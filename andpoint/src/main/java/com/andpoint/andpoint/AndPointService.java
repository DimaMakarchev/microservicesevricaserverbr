package com.andpoint.andpoint;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Set;

@EnableBinding(Processor.class)
@MessageEndpoint
public class AndPointService {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Order methodMessageEndpoint(Order order) {
        Set<Integer> integerSet = Set.of(1, 2, 4, 5);

        Order checkedOrder = new Order(order.getId(),
                order.getType(),
                order.getName(),
                "checked1111111111111");
        if (integerSet.contains(order.getId())) {
            checkedOrder.setStatus("unchecked2222222222222222222");
        }

        System.out.println(checkedOrder);

        return checkedOrder;


    }

}
