package com.springcloud.order.controller;

import com.springcloud.order.config.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EVNController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-11 12:26 星期四 Worklearn
 * @VERSION 1.0.0
 **/
//检验是否从配置中心获取到Config
@RestController
//配置消息刷新消息队列通知
@RefreshScope
public class EVNController {

    @Value("${EVN}")
    private String EVN;

    @GetMapping("/evn")
    public String getEVN(){
        return EVN;
    }

}
