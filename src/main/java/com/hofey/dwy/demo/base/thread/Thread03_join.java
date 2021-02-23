package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 线程插队
 * @author: yhf
 * @create: 2021-02-20 21:34
 **/
public class Thread03_join {

    public static void main(String[] args){

        Thread thread01 = new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                System.out.println("当前线程名称："+Thread.currentThread().getName()+"遍历次数"+i);
            }
        });
        thread01.start();
        Thread thread02 = new Thread(()-> {
            try {
                thread01.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println("当前线程名称："+Thread.currentThread().getName()+"遍历次数"+i);
            }
        });
        thread02.start();
        try {
            thread02.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名称："+Thread.currentThread().getName()+"遍历次数"+i);
        }
    }
}
