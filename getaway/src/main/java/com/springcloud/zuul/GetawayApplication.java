package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// 通过路由的地址访问这个url
// http://localhost:8089/product/product/list
// product表示要访问的那个配置名称
@SpringBootApplication
@EnableZuulProxy
public class GetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }
}
