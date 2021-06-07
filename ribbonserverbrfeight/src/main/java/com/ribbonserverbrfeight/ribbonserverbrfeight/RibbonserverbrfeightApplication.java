package com.ribbonserverbrfeight.ribbonserverbrfeight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonserverbrfeightApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonserverbrfeightApplication.class, args);
    }

}
