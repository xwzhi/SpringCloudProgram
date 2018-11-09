package com.boot.design.base;

import org.junit.jupiter.api.Test;

/**
 * @ClassName BaseTypeTest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-25 14:53 星期二 My1Program
 * @VERSION 1.0.0
 **/
public class BaseTypeTest {
    /*private static byte b;
    private static short s;
    private static int i;
    private static float f;
    private static double d;
    private static char c;
    private static long l;
    private static boolean bl;*/
    private byte b;
    private short s;
    private int i;
    private float f;
    private double d;
    private char c;
    private long l;
    private boolean bl;

    public static void main(String[] args){
     /* System.out.println(b);
      System.out.println(s);
      System.out.println(i);
      System.out.println(f);
      System.out.println(d);
      System.out.println(bl);
      System.out.println((int)c);
      System.out.println(l);*/
    }

    @Test
    public void test5(){
        //Son son = new Son();
        //Son son1 = new Son("xxx");
        System.out.println("这是主程序代码块");
        Son son2 = new Son(1,"d","s","s","s");
        //System.out.println(son);
        //System.out.println(son1);
        System.out.println(son2);
    }
}
