package org.liuzhilin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run( EurekaClientSecondApplication.class, args );
    }
}
