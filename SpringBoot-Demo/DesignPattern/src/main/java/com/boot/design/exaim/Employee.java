package com.boot.design.exaim;

/**
 * @ClassName Employee
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-04 19:56 星期四 My1Program
 * @VERSION 1.0.0
 **/
public class Employee {

    private String name;
    private String address;
    private Integer price;
    private int age;

    public Employee(String name, String address, Integer price, int age) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", age=" + age +
                '}';
    }

}
