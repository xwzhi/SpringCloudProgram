package com.py.property.controller;

import com.py.property.entity.Advice;
import com.py.property.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AdviceController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:30 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @GetMapping("/list")
    public List<Advice> getList() {
        return adviceService.findAll();
    }
}
