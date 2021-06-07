package com.ribbonfeignclient.ribbonfeignclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ribbonfeignclient.ribbonfeignclient.service.ServiceBrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;

@RestController
public class ControllerBrClient {

    @Autowired
    private ServiceBrClient serviceBrClient;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "failed")
    @RequestMapping("/")
    public String method() {
//        String s = serviceBrClient.methodGet();
        String forObject = restTemplate.getForObject("http://localhost:8082/get", String.class);
        return forObject;
    }

    public String failed() {
        String error = "Service is not available now. Please try later";
//        LOG.log(Level.INFO, error + "NOOOOOOOOO bro");
        return error;
    }
}
