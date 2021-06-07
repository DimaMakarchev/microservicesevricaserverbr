package com.ribbon.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ribbon.ribbon.service.GetDataServerBr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerBrClient {
    private static final Logger LOG = Logger.getLogger(ControllerBrClient.class.getName());
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GetDataServerBr getDataServerBr;

    @HystrixCommand(fallbackMethod = "failed")
    @RequestMapping("/getclientdata")
    public String methodTest() {
//        String forObject1 = restTemplate.getForObject("http://localhost:8001/getserverdata", String.class);
        String forObject1 = getDataServerBr.getDataBr();
        return forObject1;
    }

    public String failed() {
        String error = "Service is not available now. Please try later";
        LOG.log(Level.INFO, error + "NOOOOOOOOO bro");
        return error;
    }
}
