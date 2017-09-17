package org.liuzhilin.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.liuzhilin.controller.HiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Hiservice {
    private static final Logger LOGGER = LoggerFactory.getLogger( HiController.class );

    private final AtomicInteger atomicInteger = new AtomicInteger();
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
        LOGGER.warn( "ask: feign " + atomicInteger.incrementAndGet() );
        return restTemplate.getForObject( "http://service-hello/", String.class );
    }

    public String helloFallback() {
        return "i am ribbon fallback!!!!!";
    }
}
