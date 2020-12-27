package com.geek.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author geek
 */
// Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心地址和端口号。
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.geek.springcloud"})
@ComponentScan("com.geek.springcloud")
public class FeignDeptConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer80Application.class, args);
    }

}
