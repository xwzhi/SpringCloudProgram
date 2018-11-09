package com.hdo.mybatis.bean;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @ClassName Love
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 11:13 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public abstract class Love<T, Z> {

    private String simpleName;

    private String simpleName2;

    /*获取泛型参数*/
    private Class<T> clazz;
    private Class<Z> clazzZ;


    public Love() {

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] arguments = type.getActualTypeArguments();

        for (int i = 0; i < arguments.length; i++) {
            if (i == 0) {
                clazz = (Class<T>) arguments[i];
                simpleName = clazz.getSimpleName();
                System.out.println(simpleName);
            }

            if (i == 1) {
                clazzZ = (Class<Z>) arguments[i];
                simpleName2 = clazz.getSimpleName();
                System.out.println(simpleName2);
            }

        }

    }

    public T getData(String name) {
        T t = null;
        try {
            Field[] fields = clazz.getDeclaredFields();
            t = clazz.newInstance();
            for (Field field : fields) {
                if (field.getName().equals("name")) {
                    field.setAccessible(true);
                    field.set(t, new String("xx"));
                }
            }
        } catch (Exception e) {
        }

        return t;
    }


}
