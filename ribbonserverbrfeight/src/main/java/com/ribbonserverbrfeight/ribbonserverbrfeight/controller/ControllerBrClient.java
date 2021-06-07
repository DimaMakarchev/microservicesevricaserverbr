package com.ribbonserverbrfeight.ribbonserverbrfeight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBrClient {

    @Autowired
    private Environment environment;

    @RequestMapping("/get")
    public String method() {
        return environment.getProperty("local.server.port");
    }
}
