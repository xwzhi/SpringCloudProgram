package com.py.property.controller;

import com.py.property.entity.Policy;
import com.py.property.entity.WorkStatus;
import com.py.property.service.PolicyService;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PolicyController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:32 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @GetMapping("/list")
    public List<Policy> getList() {
        return policyService.findAll();
    }

}
