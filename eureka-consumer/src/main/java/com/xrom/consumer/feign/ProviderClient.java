package com.xrom.consumer.feign;

import com.xrom.consumer.fallbackFacotry.HystrixClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provider", fallbackFactory = HystrixClientFallbackFactory.class)
public interface ProviderClient {

    @GetMapping("test")
    String test();
}
