package com.py.property.controller;

import com.py.property.entity.Complaint;
import com.py.property.entity.WorkStatus;
import com.py.property.service.ComplaintService;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ComplaintController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:31 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/list")
    public List<Complaint> getList() {
        return complaintService.findAll();
    }
}
