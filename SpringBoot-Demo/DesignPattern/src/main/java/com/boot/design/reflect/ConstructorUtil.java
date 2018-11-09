package com.boot.design.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ConstructorUtil
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 12:54 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public class ConstructorUtil {

    //// 获取“名称是name，参数是parameterTypes”的public的函数(包括从基类继承的、从接口实现的所有public函数)
    //public Method getMethod(String name, Class[] parameterTypes);
    //// 获取全部的public的函数(包括从基类继承的、从接口实现的所有public函数)
    //public Method[]    getMethods();
    //// 获取“名称是name，参数是parameterTypes”，并且是类自身声明的函数，包含public、protected和private方法。
    //public Method    getDeclaredMethod(String name, Class[] parameterTypes);
    //// 获取全部的类自身声明的函数，包含public、protected和private方法。
    //public Method[]    getDeclaredMethods();
    //// 如果这个类是“其它类中某个方法的内部类”，调用getEnclosingMethod()就是这个类所在的方法；若不存在，返回null。
    //public Method    getEnclosingMethod();

    /**
     * getDeclaredConstructor() 的测试函数
     */
    public static void testGetDeclaredConstructor() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");

            // 根据class，获取构造函数
            Constructor cst1 = cls.getDeclaredConstructor();
            Constructor cst2 = cls.getDeclaredConstructor(new Class[]{String.class});
            Constructor cst3 = cls.getDeclaredConstructor(new Class[]{String.class, int.class, String.class});

            // 根据构造函数，创建相应的对象
            cst1.setAccessible(true); // 因为Person中Person()是private的，所以这里要设置为可访问
            Object p1 = cst1.newInstance();
            Object p2 = cst2.newInstance("Juce");
            Object p3 = cst3.newInstance("Jody", 34, "x");

            System.out.printf("%-30s: p1=%s, p2=%s, p3=%s\n",
                    "getConstructor()", p1, p2, p3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getConstructor() 的测试函数
     */
    public static void testGetConstructor() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");

            // 根据class，获取构造函数
            //Constructor cst1 = cls.getConstructor(); // 抛出异常，因为默认构造函数是private权限。
            //Constructor cst2 = cls.getConstructor(new Class[]{String.class});// 抛出异常，因为该构造函数是protected权限。
            Constructor cst3 = cls.getConstructor(new Class[]{String.class, int.class, String.class});

            // 根据构造函数，创建相应的对象
            //Object p1 = cst1.newInstance();
            //cst1.setAccessible(true); // 因为Person中Person()是private的，所以这里要设置为可访问
            //Object p1 = cst1.newInstance();
            //Object p2 = cst2.newInstance("Kim");
            Object p3 = cst3.newInstance("Katter", 36, "xxxx");

            System.out.printf("%-30s: p3=%s\n",
                    "getConstructor()", p3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getDeclaredMethod() 的测试函数
     */
    public static void testGetDeclaredMethod() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 获取Person中的方法
            Method mSetName = cls.getDeclaredMethod("setName", new Class[]{String.class});
            Method mGetName = cls.getDeclaredMethod("getName", new Class[]{});
            Method mSetAge = cls.getDeclaredMethod("setAge", new Class[]{int.class});
            Method mGetAge = cls.getDeclaredMethod("getAge", new Class[]{});
            Method mSetGender = cls.getDeclaredMethod("setGender", new Class[]{Gender.class});
            Method mGetGender = cls.getDeclaredMethod("getGender", new Class[]{});

            // 调用获取的方法
            mSetName.invoke(person, new Object[]{"Jimmy"});
            mSetAge.invoke(person, new Object[]{30});
            mSetGender.setAccessible(true);    // 因为Person中setGender()是private的，所以这里要设置为可访问
            mSetGender.invoke(person, new Object[]{Gender.MALE});
            String name = (String) mGetName.invoke(person, new Object[]{});
            Integer age = (Integer) mGetAge.invoke(person, new Object[]{});
            mGetGender.setAccessible(true);    // 因为Person中getGender()是private的，所以这里要设置为可访问
            Gender gender = (Gender) mGetGender.invoke(person, new Object[]{});

            // 打印输出
            System.out.printf("%-30s: person=%s, name=%s, age=%s, gender=%s\n",
                    "getDeclaredMethod()", person, name, age, gender);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * getMethod() 的测试函数
     */
    public static void testGetMethod() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 获取Person中的方法
            Method mSetName = cls.getMethod("setName", new Class[]{String.class});
            Method mGetName = cls.getMethod("getName", new Class[]{});
            //Method mSetAge  = cls.getMethod("setAge", new Class[]{int.class});         // 抛出异常，因为setAge()是protected权限。
            //Method mGetAge  = cls.getMethod("getAge", new Class[]{});                  // 抛出异常，因为getAge()是protected权限。
            //Method mSetGender = cls.getMethod("setGender", new Class[]{Gender.class}); // 抛出异常，因为setGender()是private权限。
            //Method mGetGender = cls.getMethod("getGender", new Class[]{});             // 抛出异常，因为getGender()是private权限。

            // 调用获取的方法
            mSetName.invoke(person, new Object[]{"Phobe"});
            //mSetAge.invoke(person, new Object[]{38});
            //mSetGender.invoke(person, new Object[]{Gender.FEMALE});
            String name = (String) mGetName.invoke(person, new Object[]{});
            //Integer age = (Integer)mGetAge.invoke(person, new Object[]{});
            //Gender gender = (Gender)mGetGender.invoke(person, new Object[]{});

            // 打印输出
            System.out.printf("%-30s: person=%s\n",
                    "getMethod()", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * getEnclosingMethod() 的测试函数
     */
    public static void testGetEnclosingMethod() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 根据class，调用Person类中有内部类InnerB的函数
            Method mGetInner = cls.getDeclaredMethod("getInner", new Class[]{});

            // 根据构造函数，创建相应的对象
            mGetInner.invoke(person, new Object[]{});

            System.out.printf("%-30s: person=%s\n",
                    "getEnclosingMethod", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // getDeclaredField() 的测试函数
        testGetDeclaredField();

        // getField() 的测试函数
        testGetField();
    }

    /**
     * getDeclaredField() 的测试函数
     * getDeclaredField() 用于获取的是类自身声明的所有成员遍历，包含public、protected和private方法。
     */
    public static void testGetDeclaredField() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 根据class，获取Filed
            Field fName = cls.getDeclaredField("name");
            Field fAge = cls.getDeclaredField("age");
            Field fGender = cls.getDeclaredField("gender");

            // 根据构造函数，创建相应的对象
            fName.set(person, "Hamier");
            fAge.set(person, 31);
            fGender.setAccessible(true);  // 因为"flag"是private权限，所以要设置访问权限为true；否则，会抛出异常。
            fGender.set(person, Gender.FEMALE);

            System.out.printf("%-30s: person=%s\n",
                    "getDeclaredField()", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getField() 的测试函数
     * getField() 用于获取的是public的“成员”
     */
    public static void testGetField() {
        try {
            // 获取Person类的Class
            Class<?> cls = Class.forName("com.boot.design.reflect.Person");
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 根据class，获取Filed
            Field fName = cls.getField("name");
            Field fAge = cls.getDeclaredField("age");       // 抛出异常，因为Person中age是protected权限。
            Field fGender = cls.getDeclaredField("gender"); // 抛出异常，因为Person中gender是private权限。

            // 根据构造函数，创建相应的对象
            fName.set(person, "Grace");
            //fAge.set(person, 26);
            //fGender.set(person, Gender.FEMALE);

            System.out.printf("%-30s: person=%s\n",
                    "getField()", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

