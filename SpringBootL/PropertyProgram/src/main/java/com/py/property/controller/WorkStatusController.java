package com.py.property.controller;

import com.py.property.entity.WorkStatus;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName WorkStatusController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 10:09 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/wStatus")
public class WorkStatusController {

    @Autowired
    private WorkStatusService workStatusService;

    @GetMapping("/list")
    public List<WorkStatus> getList() {
        return workStatusService.findAll();
    }

}