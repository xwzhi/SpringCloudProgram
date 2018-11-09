package com.py.property.controller;

import com.py.property.entity.Directories;
import com.py.property.entity.WorkStatus;
import com.py.property.service.DirectoriesService;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DirectoriesController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:31 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/directories")
public class DirectoriesController {

    @Autowired
    private DirectoriesService directoriesService;

    @GetMapping("/list")
    public List<Directories> getList() {
        return directoriesService.findAll();
    }

}
