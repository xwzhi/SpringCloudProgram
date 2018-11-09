package com.boot.design.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TransforValue
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-26 08:42 星期三 My1Program
 * @VERSION 1.0.0
 **/
public class TransforValue {

    private String value="test";

    private char ch;

    private char [] chars={'a','b','c'};

    private static void fun1(String value,char[] chars){
        value="1";
        chars[0]='3';
    }

    public static void main(String[] args){
      TransforValue transforValue = new TransforValue();
      fun1(transforValue.value,transforValue.chars);
      System.out.print(transforValue.value+" and ");
      System.out.println(transforValue.chars);
    }

    @Test
    public void test(){
       System.out.println(tryCatchTest(10));
    }

    @Test
    public void test12(){

        double d=12.5d;
        System.out.println(d);
        System.out.println(d+"xxx");
    }

    @Test
    public void test3(){
        Number number=012;
        Number number1=0x12;
        System.out.println(number);
        System.out.println(number1);
        List list = new ArrayList();
    }

    @Test
    public void test4(){
        System.out.println("\u0000");
        System.out.println(ch);
    }

    public static int tryCatchTest(int a){
        try{
            System.out.println("a="+a);
            a=a/0;
            return --a;
        }catch (Exception e){
            System.out.println("a="+a);
            --a;
            System.out.println("a="+a);
            --a;
            System.out.println("a="+a);
            return --a;
        }finally {
            System.out.println("a="+a);
            return --a;
        }
    }
}
