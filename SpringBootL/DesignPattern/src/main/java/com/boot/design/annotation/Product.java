package com.boot.design.annotation;

/**
 * @ClassName Product
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-15 13:47 星期一 Worklearn
 * @VERSION 1.0.0
 **/
public class Product {

    private String name;

    private Integer age;

    public Product() {
    }

    public Product(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @IsNeed
    private void print(String name,Integer pad){
        System.out.println(name+pad);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
