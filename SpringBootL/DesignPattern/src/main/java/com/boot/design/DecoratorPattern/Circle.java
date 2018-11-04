package com.boot.design.DecoratorPattern;

//创建实现接口的实体类
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}