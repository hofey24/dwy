package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 线程学习，通过实现runnable 接口 创建线程 并启动线程
 * @author: yhf
 * @create: 2021-02-20 21:12
 **/
public class Thread02 implements Runnable {



    public static void main(String[] args) {

        Thread thread = new Thread(new Thread02());
        thread.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println("当前线程名称"+Thread.currentThread().getName()+" 当前循环次数："+(i+1));
        }
    }

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
        for (int i = 0; i <10 ; i++) {
            System.out.println("当前线程名称"+Thread.currentThread().getName()+" 当前循环次数："+(i+1));
        }
    }
}
