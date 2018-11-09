package com.boot.design.simplefactory;

/**
 * @ClassName HistoryFactory
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-15 22:08 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class HistoryFactory implements BeanFactory {

    @Override
    public Library produce() {
        return new HistoryType();
    }
}
