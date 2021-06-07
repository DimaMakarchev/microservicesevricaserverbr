package com.ribbonfeignclient.ribbonfeignclient.service;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "ribbonserverbrfeight")
//@RibbonClient(name = "ribbonserverbrfeight")
public interface ServiceBrClient {

    @RequestMapping("/get")
    String methodGet();

}
