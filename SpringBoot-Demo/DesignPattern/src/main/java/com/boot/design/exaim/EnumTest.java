package com.boot.design.exaim;

/**
 * @ClassName EnumTest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 17:30 星期四 My1Program
 * @VERSION 1.0.0
 **/
public enum EnumTest {

    //枚举类有多少实例 就调用多少次实例对象
    ONE,TWO,THREE,FIVE;

    private EnumTest() {
       System.out.println("This is a enum Type;");
    }
}
