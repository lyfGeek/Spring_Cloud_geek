package com.geek.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author geek
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard9001Application.class, args);
    }

}
