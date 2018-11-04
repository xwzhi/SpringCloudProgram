package com.boot.design.base;

/**
 * @ClassName vartest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-16 17:38 星期日 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class vartest {
    //Java 中静态变量和实例变量区别
    // 静态变量属于类，该类不生产对象，通过类名就可以调用静态变量。
    // 实例变量属于该类的对象，必须产生该类对象，才能调用实例变量。
    //在程序运行时的区别：
    //
    //实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被分配空间，才能使用这个实例变量。
    // 静态变量不属于某个实例对象，而是属于类，所以也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，静态变量就会
    // 被分配空间，静态变量就可以被使用了。
    //总之，实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。
    //
    //例如，对于下面的程序，无论创建多少个实例对象， 永远都只分配了一个 staticInt 变量，并且每创建一个实例对象，这个 staticInt
    // 就会加 1；但是，每创建一个实例对象，就会分配一个 random， 即可能分配多个 random ，并且每个 random 的值都只自加了1次。
    public static void main(String[] args){
      //User user =new User();
      //user.setY(1);
      //user.setX(1);
      //System.out.println(user.getY()+user.getX()); //1 1
      //
      //User user1=new User();
      //user1.setY(2);
      //user1.setX(2);
      //System.out.println(user.getY()+user.getX()); // 2 1
      //System.out.println(user1.getY()+user1.getX()); // 2 2
    }
}
