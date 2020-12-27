package com.geek.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author geek
 */
@Configuration// Spring applicationContext.xml。
public class ConfigBean {

//    AvailabilityFilteringRule;会先过滤掉，跳闸、访问故障的服务，对剩下的进行轮询。
//    BestAvailableRule;
//    ClientConfigEnabledRoundRobinRule;
//    RandomRule;随机。
//    RetryRule;会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试。
//    RoundRobinRule;轮询。
//    WeightedResponseTimeRule;
//    ZoneAvoidanceRule;
//    ResponseTimeWeightedRule;//deprecated.


    /**
     * 配置负载均衡实现 RestTemplate。
     *
     * @return
     */
    @LoadBalanced// Ribbon。
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

/*
    @Bean
    public IRule myIRule() {
        return new RandomRule();
    }
*/

}
