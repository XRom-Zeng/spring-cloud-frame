package com.xrom.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String home(){
        return "this is eureka provider 2, " + "port:" + port;
    }
}
