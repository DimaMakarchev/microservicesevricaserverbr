package com.repitclient.repitclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.repitclient.repitclient.service.ServiceRepitBroClient;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.LogManager;

@RestController
public class ControllerForBroClient {



    @Autowired
    private ServiceRepitBroClient serviceRepitBroClient;

    @HystrixCommand(fallbackMethod = "failed")
    @RequestMapping("/clientrepit")
    public Object methodRepit() {

        String o = serviceRepitBroClient.repitServiceMethod2();
        return o;
    }

    public String failed() {
        String error = "Service is not available now. Please try later";
//        Log.class.(Level.INFO, error + "NOOOOOOOOO bro");
        return error;
    }

}
