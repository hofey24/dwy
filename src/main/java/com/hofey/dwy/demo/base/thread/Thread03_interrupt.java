package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 线程插队
 * @author: yhf
 * @create: 2021-02-20 21:34
 **/
public class Thread03_interrupt {

    public static void main(String[] args){

        Thread thread01 = new Thread(() -> {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        });
        thread01.start();
        thread01.interrupt();
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名称："+Thread.currentThread().getName()+"遍历次数"+i);
        }
    }
}
