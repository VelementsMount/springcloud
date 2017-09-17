package org.liuzhilin.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-hello", url="${service_hello.ribbon.listOfServers}",fallback = HelloClientFallback.class)
public interface HelloClient {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String hello();
}
