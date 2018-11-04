package com.boot.design.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName INeed
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-20 08:51 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class Demo {

    @Test
    public void test1() throws Exception {
        Class clazz=Class.forName("com.boot.design.reflect.User");
        System.out.println("类名:"+clazz.getName());
        System.out.println("类名:"+clazz.getSimpleName());
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length ; i++) {
            System.out.println(fields[i].getName());
        }
        Field username = clazz.getDeclaredField("username");
       //username.isAnnotationPresent();
        /*Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Object invoke = methods[i].invoke("setUsername", String.class);
        }*/

        Method method = clazz.getDeclaredMethod("setUsername", String.class);
        method.setAccessible(true);
        Object obj=clazz.newInstance();

        method.invoke(obj,"This is a very nice method");

        Constructor constructor = clazz.getDeclaredConstructor(String.class, String.class, Date.class);
        User o = (User)constructor.newInstance("Mike", "", new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").parse("2017年12月11日 15时12分12秒"));
        //User o1 = (User)constructor.newInstance("Mike", "", new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
        System.out.println(o);
        //System.out.println(o1);

    }
}
