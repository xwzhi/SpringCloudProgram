package com.boot.design.JVMModel;


import org.junit.jupiter.api.Test;

/**
 * @ClassName FinalizeEscapeGC
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-02 15:03 星期二 My1Program
 * @VERSION 1.0.0
 **/
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("This object is alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("This method is executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一会拯救自己 因为任何一个对象的finalize()方法 都只会被系统调动一次
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);

        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
            System.out.println(SAVE_HOOK);
        }else{
            System.out.println("hhhhhhhhhhhhhhh");
        }

        //对象第一会拯救自己 因为任何一个对象的finalize()方法 都只会被系统调动一次
        SAVE_HOOK=null;
        System.gc();

        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("hhhhhhhhhhhhhhh");
        }
    }

    @Test
    public void test1(){
        String a = "abc";
        String b = "abc";
        String c = "abc";
        String d = new String("abc");
        String e = new String("abc");
        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(a==d);
        System.out.println(a.equals(d));
        System.out.println(a==e);
        System.out.println(d==e);
    }

    @Test
    public void test2(){

        int index = 0;

        synchronized (this){
            while(index <= 100){
                final int i=index;
                Thread  thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("index:"+i);
                    }
                });
                index++;
                thread.start();
            }
        }

    }

    @Test
    public synchronized void test3() throws  Exception{

        //线程
        AppleTest appleTest = new AppleTest();

        //线程实例
        Thread thread1 = new Thread(appleTest,"a");
        Thread thread2 = new Thread(appleTest,"b");
        Thread thread3 = new Thread(appleTest,"c");


        thread1.start();
        thread2.start();
        thread3.start();

    }
}
