package com.boot.design.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @ClassName Nice
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-15 13:49 星期一 Worklearn
 * @VERSION 1.0.0
 **/
public class Nice {

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("com.boot.design.annotation.Product");

        Method print = clazz.getDeclaredMethod("print", String.class, Integer.class);

        boolean present = print.isAnnotationPresent(IsNeed.class);

        if (present) {

            AnnotatedType returnType = print.getAnnotatedReturnType();

            Type type = returnType.getType();

            String typeName = type.getTypeName();

            Annotation[] annotations = print.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> aClass = annotation.annotationType();
                String className=aClass.getSimpleName();
            }
            IsNeed isNeed = print.getAnnotation(IsNeed.class);

            System.out.println("name:" + isNeed.code());

            System.out.println("age:" + isNeed.message());

        }

    }
}
