package com.boot.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AOPDemo
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-05 17:19 星期五 My1Program
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping
public class AOPDemo {

    @GetMapping
    @ResponseBody
    public String toIndexHtml(HttpServletRequest request){
        String msg =(String)request.getAttribute("msg");
        for (int i = 0; i < 100; i++) {
             System.out.println(i+msg);
        }
        return "我们是一个好孩子！";
    }

    @GetMapping("/index")
    public String toIndex(){
       System.out.println("This is a very nice idea !");
       return "oodyfuck You";
    }
}
