package com.hofey.dwy.demo.base.thread;

/**
 * @Author: hofey
 * @Date: 2020/7/17 17:26
 * @Description:
 */
public class ThreadTest {
    static int ticket = 10;


    public static void main(String[] args) {
        for (int i = 0; i <=10 ; i++) {
            new Thread01(System.currentTimeMillis()).start();
            System.out.println("剩余票数："+ticket);
        }



    }
}
