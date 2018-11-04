package com.boot.design.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName IsNeed
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-15 13:39 星期一 Worklearn
 * @VERSION 1.0.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IsNeed {

    //另外，还有一种情况。如果一个注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内。
    int code() default -1;

    String message() default  "This is a error message ! ";
}
