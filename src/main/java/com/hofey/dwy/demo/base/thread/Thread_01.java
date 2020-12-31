package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 创建并启动线程
 * 创建线程的方式有两种 一种是 继承Thread类 另一种是 实现 rannable 接口
 *
 *
 * @author: yhf
 * @create: 2020-07-12 13:58
 **/
public class Thread_01{






    public static void main(String[] args) {
        System.out.println("主方法1");
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //myThread.flag=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread myThread1 = new MyThread();

        System.out.println("主方法2");

    }
}
class MyThread implements Runnable{
    boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            System.out.println("=="+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

    }
}