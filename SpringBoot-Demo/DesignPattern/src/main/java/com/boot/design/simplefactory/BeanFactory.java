package com.boot.design.simplefactory;

/**
 * @ClassName FanctoryDesignPattern
 * @Author XuWeiZhi
 * @Description
 *   1.简单工厂模式有一个问题，类的创建依赖工厂，也就是说，想要扩展程序，必须扩展工厂类，
 * 这样就违背了闭包原则，
 *   2.工厂方法模式完美的解决这一类问题：创建一个工厂接口和多个工厂接口的实现类，这样增加新功能，增加新的工厂类就可以了。
 * @Date 2018-09-15 22:00 星期六 SpringBootProgram
 * @VERSION 1.0.0
 **/
public interface BeanFactory {

    public Library produce();
}
