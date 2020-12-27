package com.geek.springcloud;

import com.geek.myrule.GeekRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author geek
 */
// Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心地址和端口号。
@EnableEurekaClient
@SpringBootApplication
// 在微服务启动时加载自定义的 Ribbon 算法类。
@RibbonClient(value = "SPRINGCLOUD-PROVIDER-DEPT", configuration = GeekRule.class)
public class DeptConsumer_80Application {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80Application.class, args);
    }

}
