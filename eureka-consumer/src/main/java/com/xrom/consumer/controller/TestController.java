package com.xrom.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xrom.consumer.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderClient providerClient;

    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping("rest")
    public String rest() {
        return restTemplate.getForEntity("http://eureka-provider/test", String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping("/feign")
    public String feign() {
        return providerClient.test();
    }

    public String defaultStores() {
        return "feign + hystrix, 提供服务挂了";
    }
}
