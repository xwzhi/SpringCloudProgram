package com.py.property.controller;

import com.py.property.entity.Affairs;
import com.py.property.service.AffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AffairsController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:30 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/affairs")
public class AffairsController {
    @Autowired
    private AffairsService affairsService;

    @GetMapping("/list")
    public List<Affairs> getList() {
        return affairsService.findAll();
    }
}
