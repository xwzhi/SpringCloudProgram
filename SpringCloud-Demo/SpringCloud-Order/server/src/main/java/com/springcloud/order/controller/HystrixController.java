package com.springcloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @ClassName HystrixController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-09 14:14 星期五 MySpringCloud
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


    //服务降级，方法体中服务服务出现问题，调用fallback 进行错误提示,可用于抛出异常
    //考虑更多的是时间的延迟，默认的延迟时间是一秒触发降级 HystrixCommandProperties default_executionTimeoutInMilliseconds 中
    //设置超时时间为3000ms 3s内服务不降级处理 配置文件也可配置
    /*@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    //配置文件单独配置一个降级时间 commandKey 设置参数名称 默认方法名
    @HystrixCommand
    @GetMapping("/getProductList")
    public String getProductList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder", Arrays.asList("164103465734242707"), String.class);
    }

    // 重试机制和断路器模式 一般是某个服务故障或异常引起，类似“保险丝”，当某个异常被触发，直接熔断整个服务，而不是等到此服务超时
    //服务熔断 circuitBreaker 断路器
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                    //设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),       //滚动窗口最小请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //断路器打开时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")      // 60 表示失败60%的次数，断路器会被打开
    })
    @GetMapping("/getList")
    public String getList(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder", Arrays.asList("164103465734242707"), String.class);
    }

    @GetMapping("/defaultFallback")
    public String getData() {
        throw new RuntimeException("服务降级默认方法测试！");
    }


    public String defaultFallback() {
        return "这是Hystrix默认的一个服务降级回调方法!适用于全局回调方法！";
    }

    public String fallback() {
        return "这是一个错误的信息提示，请稍后再试!";
    }

}


