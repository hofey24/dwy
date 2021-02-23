package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 线程通信
 * @author: yhf
 * @create: 2021-02-22 20:36
 **/
public class Thread_Communication {
    public static Object lock = new Object();


    public static void main(String[] args) {
        ThreadFirst threadFirst =new ThreadFirst();
        ThreadSecond threadSecond = new ThreadSecond();
        threadFirst.start();
        threadSecond.start();
    }


}



class ThreadFirst extends Thread{
    @Override
    public void run() {
        super.run();
        synchronized (Thread_Communication.lock){
            for (int i = 0; i <10 ; i++) {
                if(i==5){
                    //当i==5 时,当前线程进入等待状态
                    try {
                        Thread_Communication.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"正在执行"+i);
            }
        }

    }
}



class ThreadSecond extends Thread{
    @Override
    public void run() {
        super.run();
        synchronized (Thread_Communication.lock){
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"正在执行"+i);
            }
            Thread_Communication.lock.notify();
        }
    }
}
