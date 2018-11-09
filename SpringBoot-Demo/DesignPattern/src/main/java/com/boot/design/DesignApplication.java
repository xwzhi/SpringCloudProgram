package com.boot.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 设计模式六大原则：
 * 总原则：开闭原则--程序可扩展，不可修改。在程序功能不能满足当前的需求时，不能更改之前的原代码，而是扩展之前的
 * 原代码。要达到这样的效果，需要些接口和抽象类
 * 1.每个类的功能单一，解耦合。
 * 2.里氏替换原则，鉴于字数过多，请自行查阅资料。
 * 3.依赖倒转原则：面向接口编程，依赖于抽象而不是依赖于具体。
 * 4.接口隔离原则：每个接口中不存在子类必须实现的接口，如果有请分离接口。
 * 使用多个隔离接口比使用单个接口（多个接口集中在一起）的效果好。
 * 参考Collection 与List Set Map 关系 或者Spring BeanFactory与其子类BeanFactory关系
 * 5.迪米特原则（最少知道原则）
 * 一个类对自己依赖的类知道的越少越好。
 * 换一种说法：只于直接的朋友通信。类之间只要有耦合关系，就叫朋友关系。耦合分为依赖，关联，聚合，组合等。
 * 我们称出现的成员变量，方法参数，方法返回值中的类为直接朋友。局部变量，临时变量则不是直接的朋友，我们要求陌生的类
 * 不要作为局部变量出现在类中。
 **/
@SpringBootApplication
public class DesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
    }
}
