package com.springcloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Author XuWeiZhi
 * @Description 请求服务端第三种方式
 * @Date 2018-10-08 16:49 星期一 My1Program
 * @VERSION 1.0.0
 **/
//@Component
public class RestTemplateConfig {

 /*   @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
*/
}
