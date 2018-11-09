package com.springcloud.order.controller;

import com.springcloud.order.config.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GirlController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-11 16:10 星期四 Worklearn
 * @VERSION 1.0.0
 **/
@RestController
public class GirlController {

    @Autowired
    private Girl girl;

    @GetMapping("/girl")
    public String getGrilMessage(){
        return "Gril's Name:"+girl.getName()+" \n Gril's Age:"+girl.getAge();
    }
}
