package com.boot.design.annotation;

import java.lang.annotation.*;

/**
 * @ClassName INeed
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-15 13:23 星期一 Worklearn
 * @VERSION 1.0.0
 **/
//1.RetentionPolicy.SOURCE 只在源码阶段保留，编译期会被擦除
//2.RetentionPolicy.CLASS 注解只保留到编译期，不会被加载到JVM中
//3.RetentionPolicy.RUNTIME 注解保留到程序运行的时候,
@Retention(RetentionPolicy.RUNTIME)
@Documented//把注解保留到文档中
/*Target 是目标的意思，@Target 指定了注解运用的地方。
你可以这样理解，当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。
类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，
比如只能张贴到方法上、类上、方法参数上等等。@Target 有下面的取值
ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
ElementType.CONSTRUCTOR 可以给构造方法进行注解
ElementType.FIELD 可以给属性进行注解
ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
ElementType.METHOD 可以给方法进行注解
ElementType.PACKAGE 可以给一个包进行注解
ElementType.PARAMETER 可以给一个方法内的参数进行注解
ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举*/
@Target(ElementType.METHOD)
@Inherited//假如使用的注解有@Inherited注解，那么标注该注解的子类也用该注解的效果
public @interface INeed {

}
