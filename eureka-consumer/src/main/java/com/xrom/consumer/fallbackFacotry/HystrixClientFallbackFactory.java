package com.xrom.consumer.fallbackFacotry;

import com.xrom.consumer.feign.ProviderClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory {

    @Override
    public ProviderClient create(Throwable throwable) {
        return () -> "feign + hystrix, 提供服务挂了 -FallbackFactory";
    }

}