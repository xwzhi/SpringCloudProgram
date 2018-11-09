package com.boot.design.exaim;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMain
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 17:18 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class TestMain {

    public static void main(String[] args) {
        Nice nice = new Nice();
        nice.test();
    }

    @Test
    public void test() {
        System.out.println(EnumTest.ONE);
    }

    @Test
    public void test1() {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

    @Test
    public void test3() {
        int x = 1;
        float y = 1;
        System.out.println(x / y);
    }

    @Test
    public void test2() {
        boolean[] b = new boolean[10];
        System.out.print(b[0] + "\n");
        System.out.print(b[0]);
        System.out.print(b[0]);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("xx");
    }

    @Test
    public void test4() {
        StringBuffer sb = new StringBuffer();
        System.out.println("StringBuffer初始长度：" + sb.length());
        System.out.println("StringBuffer容器长度：" + sb.capacity());
        for (int i = 0; i < 10; i++) {
            sb.append("01xsdsasss");
            System.out.println("StringBuffer长度：" + sb.length());
            System.out.println("StringBuffer容器长度：" + sb.capacity());
        }
    }

    @Test
    public void test5() {
        List list = new ArrayList<>();
        System.out.println("StringBuffer初始长度：" + list.size());
        for (int i = 0; i < 10; i++) {
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            System.out.println("StringBuffer长度：" + list.size());
        }
    }

}
