package com.userservice.userservice.controller;

import com.userservice.userservice.model.Bucket;
import com.userservice.userservice.service.TestService;
import com.userservice.userservice.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class ControllerUserServiceForBro {
    private Logger logger = Logger.getLogger(ControllerUserServiceForBro.class.getName());

    @Autowired
    private TestService service;

    @Autowired
    private WebClientService webClientService;

    @GetMapping("/data")
    public String data() {
        return service.data();
    }

    @GetMapping("/")
    public String dataip() {
        return service.ip();
    }

    @GetMapping(value = "/getDataByWebClient", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Bucket> getDataByWebClient() {
        logger.info("Calling through WebClient");
        return webClientService.getDataByWebClient();
    }
}
