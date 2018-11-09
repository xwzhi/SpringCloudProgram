package com.boot.design.JVMLearn;

/**
 * @ClassName demo1
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-16 23:05 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class demo1 {
    public static void main(String[] args) {
        Object obj = new Object();

        User user = new User();
        //获取跟加载器
        //JRE java 运行环境
        System.out.println(obj.getClass().getClassLoader());
        System.out.println("--------------------------");
        Thread.currentThread().getName();
        System.out.println(user.getClass().getClassLoader().getParent().getParent());
        //扩展类加载器
        System.out.println(user.getClass().getClassLoader().getParent());
        //系统类加载器
        System.out.println(user.getClass().getClassLoader());
        //双亲委派机制和沙盒安全加载机制/
        // JVM会首先加载自带（顶层）的class文件 保证了源代码的安全性
        //多线程启动
        new Thread(()->{
           System.out.println("xxx");
        },"男男女女女女女女女").start();
        Thread.currentThread().getName();
    }
}
