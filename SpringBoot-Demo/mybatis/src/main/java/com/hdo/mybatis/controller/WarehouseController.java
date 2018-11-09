package com.hdo.mybatis.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.hdo.mybatis.bean.Warehouse;
import com.hdo.mybatis.service.AsyncService;
import com.hdo.mybatis.service.LoginnumService;
import com.hdo.mybatis.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

/**
 * @ClassName WarehouseController
 * @Author XWZ
 * @Description
 * @Date 2018-09-09 22:06 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private LoginnumService loginnumService;

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/get")
    public void getWarehouse(Integer id, PrintWriter out){
        Warehouse warehouse=loginnumService.getWarehouse(id);
        out.print(JSONObject.toJSONString( warehouseService.getWarehouse(id)));
        out.flush();
        out.close();
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateWarehouse(Warehouse warehouse){
        warehouseService.update(warehouse);
        return "";
    }

    @RequestMapping("/asynce")
    @ResponseBody
    public String toTets(){
        asyncService.hello();
        return "success";
   }
}
