package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 线程通信进出水小程序
 * @author: yhf
 * @create: 2021-02-23 21:27
 **/
public class Thread_Communication02 {
    public static final int MAX_CAPACITY = 10;//水池最大容量
    public static int init_capacity = 0;

    public static Object lock = new Object();

    public static void main(String[] args) {


        /**进水*/
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (init_capacity < MAX_CAPACITY) {
                        System.out.println("进水");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        init_capacity++;
                        lock.notify();
                    } else {
                        System.out.println("水已满");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        /**出水*/
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (init_capacity > 0) {
                        System.out.println("出水操作");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        init_capacity--;
                        lock.notify();
                    }else {
                        System.out.println("水池已空");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

}
