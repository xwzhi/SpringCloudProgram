package com.boot.design.exaim;

/**
 * @ClassName OutClass
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 17:05 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class OutClass {

    String a = "a";
    static String b = "b";
    private String c = "c";
    private static String d = "d";

    private static void toIndex(){
        System.out.println("This is a very nice method;");
    }

    class InnerClass {

        public void test() {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }

    }

    static class Inner1Class {

        public static void test() {
            //System.out.println(a);
            System.out.println(b);
            //System.out.println(c);
            System.out.println(d);
        }
    }

    public static void main(String[] args) {

        OutClass outClass = new OutClass();
        InnerClass inner1 = outClass.new InnerClass();
        OutClass.InnerClass inner2 = outClass.new InnerClass();

        inner1.test();
        inner2.test();

        OutClass.Inner1Class.test();

    }
}

class Nice{

    public void test(){
        System.out.println("HaHaHa");
    }
}
