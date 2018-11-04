package com.boot.design.simplefactory;

/**
 * @ClassName CarFactory
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-15 22:07 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class CarFactory implements BeanFactory {

    @Override
    public Library produce() {
        return new CarType();
    }
}
