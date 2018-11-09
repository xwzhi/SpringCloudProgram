package com.boot.design.singleton;

/**
 * 1、懒汉式，线程不安全
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：否
 * <p>
 * 实现难度：易
 * <p>
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 **/
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //2、懒汉式，线程安全
    //是否 Lazy 初始化：是
    //
    //是否多线程安全：是
    //
    //实现难度：易
    //
    //描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
    //优点：第一次调用才初始化，避免内存浪费。
    //缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
    //getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）

    /*private static Singleton instance;

    private Singleton (){}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }*/


    //但是，synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，因为每次调用getInstance()，
    // 都要对对象上锁，事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了，所以，这个地方需要改进。我们改成下面这个：
    /*private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    // 似乎解决了之前提到的问题，将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，
    // 并创建对象的时候才需要加锁，性能有一定的提升。但是，这样的情况，还是有可能有问题的，看下面的情况：在Java指令中创建对象
    // 和赋值操作是分开进行的，也就是说instance = new Singleton();语句是分两步执行的。但是JVM并不保证这两个操作的先后顺
    // 序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，然后再去初始化这个Singleton实例。
    // 这样就可能出错了，我们以A、B两个线程为例：
    //   a  A、B线程同时进入了第一个if判断
    //   b  A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
    //   c  由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员
    //     （注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
    //   d  B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
    //   e  此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。 所以程序还是有可能发生错误，其实程序在运行过
    //      程是很复杂的，从这点我们就可以看出，尤其是在写多线程环境下的程序更有难度，有挑战性。我们对该程序做进一步优化：
    //  考虑性能的话，整个程序只需创建一次实例，所以性能也不会有什么影响。

    //private Static Singleton instance = null;
    //public Singleton(){};

    //public static synchronized void syncInit(){
    // if(instance == null){
    //   instaince = new Singleton();
    //  }
    // }
    //public static Singleton getInstance(){
    //   if(instance = null){
    //     instance = syncInit();
    //    }
    //   return instance;
    // }
}