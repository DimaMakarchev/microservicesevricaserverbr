package com.repitclient.repitclient.service;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("repit-service")
@RibbonClient("repit-service")
@Service
public interface ServiceRepitBroClient {
    @RequestMapping("/getall")
    public String repitServiceMethod();

    @RequestMapping("/getall2")
    public String repitServiceMethod2();
}
