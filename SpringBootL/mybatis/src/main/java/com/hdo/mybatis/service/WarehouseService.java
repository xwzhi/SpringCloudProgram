package com.hdo.mybatis.service;

import com.hdo.mybatis.bean.Warehouse;

/**
 * @ClassName WarehouseService
 * @Author XWZ
 * @Description
 * @Date 2018-09-09 22:10 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
public interface WarehouseService {

    public Warehouse getWarehouse(Integer id);
    public Warehouse update(Warehouse warehouse);

}
