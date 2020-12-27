package com.geek.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author geek
 */
@EnableEurekaServer// 服务端启动类。授受别人注册进来。
@SpringBootApplication
public class Eureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class, args);
    }

}
