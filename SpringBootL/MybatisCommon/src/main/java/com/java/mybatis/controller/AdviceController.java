package com.java.mybatis.controller;

import com.java.mybatis.mapper.AdviceMapper;
import com.java.mybatis.model.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdviceController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-07 13:21 星期三 MySpringCloud
 * @VERSION 1.0.0
 **/
@RestController
public class AdviceController {

    @Autowired
    private AdviceMapper adviceMapper;

    @GetMapping("/index")
    public Advice getAll(){
        return adviceMapper.selectByPrimaryKey(1);
    }
}
