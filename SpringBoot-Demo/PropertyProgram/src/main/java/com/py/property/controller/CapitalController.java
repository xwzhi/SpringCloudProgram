package com.py.property.controller;

import com.py.property.entity.Capital;
import com.py.property.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CapitalController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:30 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/capital")
public class CapitalController {

    @Autowired
    private CapitalService capitalService;

    @GetMapping("/list")
    public List<Capital> getList() {
        return capitalService.findAll();
    }
}
