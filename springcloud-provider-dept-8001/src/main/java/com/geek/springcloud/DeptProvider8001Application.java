package com.geek.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableEurekaClient// 在服务启动后自动注册到 Eureka 中。
@SpringBootApplication
@EnableCircuitBreaker// 添加对熔断的支持。
public class DeptProvider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001Application.class, args);
    }

    // Dashboard Bean。
    // 添加一个 Servlet。
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
