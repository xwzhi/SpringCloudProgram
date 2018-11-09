package com.boot.design.simplefactory;

import org.springframework.stereotype.Component;

/**
 * @ClassName LibraryFactory
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-15 20:56 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
/**
 * 简单工厂模式有一个问题，类的创建依赖工厂，
 **/
@Component
public class LibraryFactory {

    /**
     * @Author XuWeiZhi
     * @Description 根据名字获取相应图书类别对象功能
     * @Date 2018/9/15 20:58
     **/
    public Library getLibaray(String name) {
        if ("car".equals(name)) {
            return new CarType();
        } else if ("history".equals(name)) {
            return new HistoryType();
        } else {
            //处理没有图书的类型
            return new DefaultType();
        }
    }

    public static Library getCarTye(){
        return new CarType();
    }
    public static Library getHistoryType(){
        return new HistoryType();
    }

}
