package com.ribbon.ribbon.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="serverbr-ribbon")
@RibbonClient(name="serverbr-ribbon")
@Service
public interface GetDataServerBr {
  @GetMapping("/getserverdata")
  public String getDataBr();
}
