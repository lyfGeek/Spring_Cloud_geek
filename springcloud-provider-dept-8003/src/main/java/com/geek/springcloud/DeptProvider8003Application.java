package com.geek.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient// 在服务启动后自动注册到 Eureka 中。
@SpringBootApplication
public class DeptProvider8003Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003Application.class, args);
    }
}
