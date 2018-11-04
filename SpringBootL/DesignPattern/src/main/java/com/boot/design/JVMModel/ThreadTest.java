package com.boot.design.JVMModel;


/**
 * @ClassName ThreadTest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-09 15:05 星期二 MyProgram
 * @VERSION 1.0.0
 **/
public class ThreadTest implements Runnable {

    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("子线程"+name+"开始运行-------");
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "运行:" + i);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("子线程"+name+"结束运行------");
    }

    /**
     *@Author XuWeiZhi
     *@Description 没加Join之前 主线程一开始就运行完了
     *
     *@Date 2018/10/9 15:22
     **/
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程"+"开始运行------");
        Thread t1 = new Thread(new ThreadTest("a"));
        Thread t2 = new Thread(new ThreadTest("b"));
        Thread t3 = new Thread(new ThreadTest("c"));
        Thread t4 = new Thread(new ThreadTest("d"));
        t1.start();
        t2.start();
        //t1.join();
        //加入Join之后主线程一定会等待此线程结束后打印
        //而且之后的线程在t1.线程结束后才会运行
        t3.start();
        t4.start();
        /*for (int i = 0; i < 10; i++) {
            System.out.println("主运行:" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println("主线程"+"结束运行------");
    }

}
