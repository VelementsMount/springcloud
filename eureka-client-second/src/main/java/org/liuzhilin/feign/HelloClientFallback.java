package org.liuzhilin.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloClientFallback implements HelloClient {
    @Override
    public String hello() {
        return "I am feignClient Fallback!!!!!!!";
    }
}
