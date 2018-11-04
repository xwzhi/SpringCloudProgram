package com.boot.design.exaim;

/**
 * @ClassName Parent
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 17:20 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class Parent {

    public Parent(){
        System.out.println("调用父类构造方法");
    }

    public static void testStaic(){
        System.out.println("调用父类静态方法");
    }

    public final void testFinal(){
        System.out.println("调用父类Finland方法");
    }


}
