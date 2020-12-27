package com.geek.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author geek
 */
public class GeekRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
