package com.hdo.mybatis.service.serviceImpl;

import com.hdo.mybatis.bean.Warehouse;
import com.hdo.mybatis.mapper.WarehouseMapper;
import com.hdo.mybatis.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName WarehoueSeriveImpl
 * @Author XWZ
 * @Description
 * @Date 2018-09-09 22:14 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Service
public class WarehoueSeriveImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Cacheable(cacheNames = "warehouse",key = "#id")
    @Override
    public Warehouse getWarehouse(Integer id) {
        return warehouseMapper.getWarehouse(id);
    }

    @CachePut(cacheNames = "warehouse",key = "#result.id")
    @Override
    public Warehouse update(Warehouse warehouse) {
        warehouseMapper.update(warehouse);
        return warehouse;
    }
}
