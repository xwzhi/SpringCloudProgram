package com.boot.design.simplefactory;

/**
 * @ClassName DefaultType
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-15 20:59 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class DefaultType implements Library {
    @Override
    public void borrowBookType() {
       throw new RuntimeException("输入不是一个图书类型,请联系系统管理员！");
    }
}
