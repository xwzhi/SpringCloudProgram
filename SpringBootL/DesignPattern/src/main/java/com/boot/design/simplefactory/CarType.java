package com.boot.design.simplefactory;

/**
 * @ClassName CarType
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-15 20:54 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class CarType implements Library {
    @Override
    public void borrowBookType() {
        System.out.println("车辆类型。。。。。。");
    }
}
