package com.hofey.dwy.demo.base.thread;

import lombok.Synchronized;

/**
 * @program: dwy
 * @description: 多线程引发的问题
 *  因为启动多个线程会出现线程抢占共享资源的问题，线程之前互相争抢CPU的执行权，使得线程访问
 *  公共资源的顺序不确定，
 * @author: yhf
 * @create: 2021-02-21 20:45
 **/
public class Thread_synchonized extends Thread {
    public static int num = 100;
    int i;
    static Object lock = new Object();//这是一把锁
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (lock){
            num = num -i;
            System.out.println(Thread.currentThread().getName()+ "卖票"+i+"张；剩余票数："+num);
        }


    }

    public Thread_synchonized(String treadName,int i) {
        super(treadName);
        this.i = i;
    }

    public static void main(String[] args) {
        Thread_synchonized thread01 = new Thread_synchonized("一号窗口",10);
        Thread_synchonized thread02 = new Thread_synchonized("二号窗口",5);
        Thread_synchonized thread03 = new Thread_synchonized("三号窗口",20);
        Thread_synchonized thread04 = new Thread_synchonized("四号窗口",10);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
    }
}
