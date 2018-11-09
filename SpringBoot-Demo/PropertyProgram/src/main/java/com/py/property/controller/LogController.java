package com.py.property.controller;

import com.py.property.entity.Log;
import com.py.property.entity.WorkStatus;
import com.py.property.service.LogService;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName LogController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:32 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/list")
    public List<Log> getList() {
        return logService.findAll();
    }
}
