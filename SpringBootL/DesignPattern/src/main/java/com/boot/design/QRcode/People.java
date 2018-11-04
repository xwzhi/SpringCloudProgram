package com.boot.design.QRcode;

/**
 * @ClassName People
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-05 20:38 星期五 My1Program
 * @VERSION 1.0.0
 **/
public class People {

    private String name;
    private Integer age;
    private String address;
    private String cardId;

    public People(String name, Integer age, String address, String cardId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.cardId = cardId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
