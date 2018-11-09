package com.hdo.mybatis.mapper;

import com.hdo.mybatis.bean.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName WarehouseMapper
 * @Author XWZ
 * @Description
 * @Date 2018-09-09 22:16 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
@Mapper
public interface WarehouseMapper {

    @Select("select * from warehouse where id=#{id}")
    public Warehouse getWarehouse(Integer id);

    @Update("update warehouse set name=#{name},address=#{address},number=#{number},zone=#{zone},shelves=#{shelves} where id=#{id}")
    public int update(Warehouse warehouse);
}
