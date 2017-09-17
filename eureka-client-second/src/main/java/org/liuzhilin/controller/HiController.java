package org.liuzhilin.controller;

import org.liuzhilin.feign.HelloClient;
import org.liuzhilin.service.Hiservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HiController.class);

    private final AtomicLong atomicLong = new AtomicLong(  );
    @Autowired
    private Hiservice hiservice;

    @Autowired
    private HelloClient helloClient;

    @GetMapping("/ribbon")
    public String hello() {
        return hiservice.hello();
    }

    @GetMapping("/feign")
    public String helloFeign() {
        LOGGER.warn( "ask: feign "+atomicLong.incrementAndGet());
        return helloClient.hello();
    }
}