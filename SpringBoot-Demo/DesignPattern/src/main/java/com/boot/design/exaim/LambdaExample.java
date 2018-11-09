package com.boot.design.exaim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @ClassName LambdaExample
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 19:46 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class LambdaExample {

    private static String dataOne = "this is a  test Data!";

    List<Employee> list = new ArrayList<>();

    public void tx(String str) {

    }

    @BeforeEach
    public void before() {
        list.add(new Employee("A", "cc", 2123, 22));
        list.add(new Employee("BC", "cc", 1223, 112));
        list.add(new Employee("Ef", "cc", 4123, 312));
        list.add(new Employee("SA", "cc", 11223, 12));
        list.add(new Employee("adf", "cc", 12323, 122));
    }

    @Test
    public void test1() {
        Runnable r1 = () -> System.out.println("This is a nice body!");
        r1.run();
    }

    /**
     * 需求1：lambda表达式的使用:
     * 调用COllections.sort方法，通过定制排序比较两个Employee（先按年龄比较，年龄相同按姓名比），使用
     * Lambda作为参数传递。
     */
    @Test
    public void test2() {

        Collections.sort(list, (old, after) -> {
            if (old.getAge() != after.getAge())
                return Integer.compare(old.getAge(), after.getAge());
            else
                return old.getName().compareTo(after.getName());

        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 需求2：
     * 1.声明函数式接口，接口中声明抽象方法，public String getvalue(String str();
     * 2.声明类TestLambda，类中编写方法使用接口作为参数，讲一个字符串转换成大写，并作为方法的返回值。
     */
    @Test
    public void test5() {
        String str = getValue("hello world", x -> x.toUpperCase());
        System.out.print(str);

    }

    public String getValue(String str, MyFunction my) {
        return my.getValue(str);
    }

    //函数式接口 表明只有一个抽象方法
    //总结 若接口的方法未实现
    //可以封装一个方法 带有这个接口的引用
    @FunctionalInterface
    public interface MyFunction {

        public String getValue(String str);

    }

    //collection
    public interface MyFunctions {

        public String getValue(String string);


        public Date getValues(Date date);
    }


    @Test
    public void testss() {

    }

    public void say(String str, MyFunctions functions) {

    }

    //list
    public interface MyFunctionss {

        public Date getDate(MyFunctions myFunctions);

    }


    @FunctionalInterface
    public interface MyInterface {
        public void printMax(Integer x, Integer y);
    }

    public void max(Integer x, Integer y, MyInterface myInterface) {
        myInterface.printMax(x, y);
    }

    ;

    @Test
    public void testMethod() {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.max(12, 13, (x1, y) -> System.out.println(x1 > y ? x1 : y));
        lambdaExample.max(132, 13, (x1, y) -> {
            if (x1 > y)
                System.out.println(x1);
            else
                System.out.println(y);
        });
    }


    /**
     * 需求3：
     * 1.声明一个带两个泛型的函数式接口，泛型类型是<T,R>,T为参数，R为返回值。
     * 2.接口中声明对应抽象方法
     * 3.在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和
     * 4.在计算两个long型参数的乘积
     */
    @Test
    public void test3() {
        Long r = getR(25l, 30l, (t1, t2) -> t1 * t2);
        System.out.println(r);

        Long r1 = getR(25l, 23l, (t1, t2) -> t1 + t2);
        System.out.println(r1);

    }

    public <T, R> R getR(T t1, T t2, MyFUnction2<T, R> mf) {
        return mf.method(t1, t2);
    }

    public interface MyFUnction2<T, R> {
        public R method(T t1, T t2);
    }


}
