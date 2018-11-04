package com.boot.design.base;

/**
 * @ClassName Son
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-26 14:10 星期三 My1Program
 * @VERSION 1.0.0
 **/
public class Son extends Person {



    private String student ;

    private String people;

    public Son() {
    }

    public Son(String student) {
        this.student = student;
    }

    public Son(int age, String name, String password, String student, String people) {
        this("xx");
        System.out.println("子类有参构造函数");
        this.student = student;
        this.people = people;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Son{" +
                "student='" + student + '\'' +
                ", people='" + people + '\'' +
                '}';
    }


    static{
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类非静态代码块");
    }
}
