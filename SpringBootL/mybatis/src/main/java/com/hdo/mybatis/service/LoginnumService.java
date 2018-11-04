package com.hdo.mybatis.service;

import com.hdo.mybatis.bean.Loginnum;
import com.hdo.mybatis.bean.Warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName LoginnumService
 * @Author XWZ
 * @Description
 * @Date 2018-09-05 17:56 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
public interface LoginnumService {

    public int save(Loginnum loginnum);

    public void delete(Integer id);

    public Loginnum update(Loginnum loginnum);

    public Loginnum getLoginnum(Integer id);

    public List<Loginnum> getAll();

    public Warehouse getWarehouse(Integer id);

}
