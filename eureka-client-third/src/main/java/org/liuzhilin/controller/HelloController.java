package org.liuzhilin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String hello() throws InterruptedException {
        //Thread.sleep( 2000 );
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        LOGGER.warn( "ask: "+serviceInstance.getHost()+":"+serviceInstance.getPort() );
      //  throw new RuntimeException( "我很好" );
        return "hello,world!"+serviceInstance.getHost()+":"+serviceInstance.getPort();
    }
}
