package com.springcloud.zuul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZuulConfig
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 16:48 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
//@Component
public class ZuulConfig {

    /*动态刷新配置*/
   /* @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties ZuulProperties(){
        return  new ZuulProperties();
    }*/

}
