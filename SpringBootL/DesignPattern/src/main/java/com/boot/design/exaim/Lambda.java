package com.boot.design.exaim;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Lambda
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 20:25 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class Lambda {

    /*  Lambda表达式的
        一、方法引用：
        若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用是Lambda表达式的另外一种表现形式）
        主要语法：
        对象：：实例方法名
        类：：静态方法名
        类：：实例方法名
        */

    /*
        Consumer<T>:消费型接口 void accept(T t);

        Supplier<T>:供给型接口 T get();

        Function<T,R>:函数型接口 R apply(T t);

        Predicate<T>:断言型接口 boolean test(T t);
        */
    @Test
    public void test1() {
        //1. 可以通过Collections系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2. 通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);

        //3. 通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("", "", "");

        //4. 创建无限流
        //迭代
        Stream.iterate(0, x -> x + 2).limit(10).forEach(System.out::println);

        //生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(System.out::println);
    }

    /**
     * 筛选和切片
     * <p>
     * filter -- 接受Lambda，从流中排除某些元素
     * limit -- 截断流，使其元素不超过某个给定数量
     * skip -- 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit互补。
     * distinct -- 去重，通过hashcode和equals去重。
     */

    List<Employee> list = Arrays.asList(
            new Employee("张三", "上海", 5000, 22),
            new Employee("李四", "北京", 4000, 23),
            new Employee("c五", "日本", 6000, 50),
            new Employee("b七", "香港", 7000, 50),
            new Employee("赵六", "纽约", 1000, 8)
    );

    @Test
    public void test2() {
        Stream<Employee> stream = list.stream();//创建流

        stream.filter(e -> e.getAge() > 25)//过滤符合条件的流元素
                .limit(5)//只取5个
                .skip(4)//跳过4个
                .distinct()//去重，需重写hashcode和equals方法
                .forEach(System.out::println);//终止操作，获取流

    }

    @Test
    public void test22() throws Exception {
        new Object();
        Class clazz = Class.forName("com.boot.design.exaim.Lambda");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    @Test
    public void test() {
        list.forEach(employee -> System.out.println(employee));
    }

}
