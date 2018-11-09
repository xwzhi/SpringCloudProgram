package com.boot.design.JVMModel;

/**
 * @ClassName AppleTest
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-02 20:49 星期二 My1Program
 * @VERSION 1.0.0
 **/
public class AppleTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("xxx");
                }
            }
        }
    }


}
