package com.py.property.controller;

import com.py.property.entity.Cases;
import com.py.property.service.CasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CasesController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:31 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/cases")
public class CasesController {

    @Autowired
    private CasesService casesService;

    @GetMapping("/list")
    public List<Cases> getList() {
        return casesService.findAll();
    }
}
