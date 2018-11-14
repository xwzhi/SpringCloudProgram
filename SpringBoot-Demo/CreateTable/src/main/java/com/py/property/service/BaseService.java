package com.py.property.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseService
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 15:19 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public interface BaseService<T> {

    void save(T t);

    void delete(T t);

    T getById(Integer id);

    List<T> findAll();

}
