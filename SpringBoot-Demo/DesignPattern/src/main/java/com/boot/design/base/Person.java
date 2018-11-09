package com.boot.design.base;

import java.util.Objects;

/**
 * @ClassName Person
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-26 14:08 星期三 My1Program
 * @VERSION 1.0.0
 **/
public class Person {

    private int age;

    private String name;

    private String password;

    public Person() {
        System.out.println("父类无参构造器");
    }

    public Person(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;
        System.out.println("父类构造器");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("父类构造器");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    static{
        System.out.println("这是父类的静态代码块");
    }

    {
        System.out.println("这是父类的非静态代码块");
    }
}
