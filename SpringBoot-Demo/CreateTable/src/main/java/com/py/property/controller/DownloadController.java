package com.py.property.controller;

import com.py.property.entity.Download;
import com.py.property.entity.WorkStatus;
import com.py.property.service.DownloadService;
import com.py.property.service.WorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DownloadController
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:32 星期五 property
 * @VERSION 1.0.0
 **/
@RestController
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @GetMapping("/list")
    public List<Download> getList() {
        return downloadService.findAll();
    }
}
