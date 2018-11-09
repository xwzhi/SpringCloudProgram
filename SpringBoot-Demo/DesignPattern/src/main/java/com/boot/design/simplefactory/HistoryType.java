package com.boot.design.simplefactory;

/**
 * @ClassName HistoryType
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-15 20:55 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class HistoryType implements Library {

    @Override
    public void borrowBookType() {
     System.out.println("历史书籍。。。。。。。。");
    }
}
