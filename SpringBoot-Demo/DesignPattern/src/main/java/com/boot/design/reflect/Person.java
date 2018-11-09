package com.boot.design.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName Person
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 12:41 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public class Person {
    private Gender gender;  // 性别
    private int age;        // 年龄
    private String name;    // 姓名

    public Person() {
        this("unknown", 0, Gender.FEMALE);
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 获取”姓名“。权限是 public
    public String getName() {
        return name;
    }

    // 设置”姓名“。权限是 public
    public void setName(String name) {
        this.name = name;
    }

    // 获取”年龄“。权限是 protected
    protected int getAge() {
        return age;
    }

    // 设置”年龄“。权限是 protected
    protected void setAge(int age) {
        this.age = age;
    }

    // 获取“性别”。权限是 private
    private Gender getGender() {
        return gender;
    }

    // 设置“性别”。权限是 private
    private void setGender(Gender gender) {
        this.gender = gender;
    }


    // getInner() 中有内部类InnerB，用来测试getEnclosingMethod()
    public void getInner() {
        // 内部类
        class InnerB {
        }
        // 获取InnerB的Class对象
        Class cls = InnerB.class;

        // 获取“封闭该内部类(InnerB)”的构造方法
        Method cst = cls.getEnclosingMethod();

        System.out.println("call--\"getInner()\" cst=" + cst);
    }


    @Override
    public String toString() {
        return "(" + name + ", " + age + ", " + gender + ")";
    }

}
