package com.springcloud.zuul;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

// 通过路由的地址访问这个url
// http://localhost:8089/product/product/list
// product表示要访问的那个配置名称
@SpringBootApplication
@EnableZuulProxy
public class GetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }

    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties ZuulProperties() {
        return new ZuulProperties();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
