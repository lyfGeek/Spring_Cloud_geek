package com.geek.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author geek
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul9527Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul9527Application.class, args);
    }

}

// http://www.geek.com:9527/springcloud-provider-dept/dept/get/1
