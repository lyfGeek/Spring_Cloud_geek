package com.geek.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker// 熔断。
@EnableDiscoveryClient
@EnableEurekaClient// 在服务启动后自动注册到 Eureka 中。
@SpringBootApplication
public class DeptProviderHystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001Application.class, args);
    }
}
