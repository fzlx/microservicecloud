package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.atguigu.springcloud")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Consumer_feign_App {

    public static void main(String[] args) {
        SpringApplication.run(Consumer_feign_App.class);
    }
}
