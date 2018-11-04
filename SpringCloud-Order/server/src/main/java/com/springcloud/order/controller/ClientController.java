package com.springcloud.order.controller;

import com.springcloud.order.client.ProductClient;
import com.springcloud.order.dataobject.ProductInfo;
import com.springcloud.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ClientController
 * @Author XuWeiZhi
 * @Description 调用其它项目API接口 第一种方式
 * @Date 2018-10-08 16:15 星期一 My1Program
 * @VERSION 1.0.0
 **/
//@RestController
//@Slf4j
public class ClientController {

    //SpringCloud内置对象，用来获取其他项目的URl,POST,地址信息
    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

    //@Autowired
    //private RestTemplate restTemplate;
    //
    //@Autowired
    //private ProductClient productClient;
    //
    //@GetMapping("/getProductMsg1")
    //public String getProductMessage() {
    //
    //    //1.获取服务端信息 缺点
    //    // a.地址写死 部署的时候不知对方地址
    //    // b.假如有多个服务，不能获取想要的服务
    //    //RestTemplate restTemplate = new RestTemplate();
    //    //String response=restTemplate.getForObject("http://localhost:8080/msg",String.class);
    //    //log.info(response);
    //
    //    //2.获取服务端信息 利用loadBalancerClient获取用户名和端口
    //    //RestTemplate restTemplate = new RestTemplate();
    //    //ServiceInstance serviceInstance = loadBalancerClient.choose("product"); //获取对应项目的名称
    //    //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort())+"/msg";
    //    //String response=restTemplate.getForObject("http://localhost:8080/msg",String.class);
    //    //log.info("response={}",response);
    //
    //    //3.详情见RestTemplateConfig 本质上和第二种方式相同
    //    //因为此处的项目端口的可能有多个，需要考虑负载均衡策略
    //    //默认使用轮询的方式 改动负载均衡策略那啥自己想办法
    //    String response = restTemplate.getForObject("http://PRODUCT/product/msg", String.class);
    //    log.info("response={}", response);
    //
    //    return response;
    //}

   /* @GetMapping("/getFeign1")
    public String getFeignMehtohd() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getOrderList1")
    public String getOrderTest() {
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("157875196366160022"));
        log.info("response={}", list);
        return list.toString();
    }

    @GetMapping("/decrease1")
    public String decrease() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 2)));
        return "xxxx";
    }*/
}
