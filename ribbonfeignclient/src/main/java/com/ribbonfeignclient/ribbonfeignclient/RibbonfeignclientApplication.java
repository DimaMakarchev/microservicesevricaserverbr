package com.ribbonfeignclient.ribbonfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
//@RibbonClient(name = "ribbonserverbrfeight")
@EnableEurekaClient
@EnableFeignClients("com.ribbonfeignclient.ribbonfeignclient")
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class RibbonfeignclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonfeignclientApplication.class, args);
    }

}
