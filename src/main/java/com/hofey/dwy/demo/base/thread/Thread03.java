package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 通过lambda表达式创建线程
 * @author: yhf
 * @create: 2021-02-20 21:34
 **/
public class Thread03 {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                System.out.println("当前线程名称："+Thread.currentThread().getName()+"遍历次数"+i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名称："+Thread.currentThread().getName()+"遍历次数"+i);
        }
    }
}
