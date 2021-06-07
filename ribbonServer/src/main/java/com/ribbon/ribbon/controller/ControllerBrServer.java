package com.ribbon.ribbon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerBrServer {

    private final RestTemplate restTemplate;

    private final Environment environment;

    @RequestMapping("/getall2")
    public String methodTest() {
        String property = environment.getProperty("local.server.port");
        return property;
    }
}
