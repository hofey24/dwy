package com.hofey.dwy.demo.base.thread;

/**
 * @Author: hofey
 * @Date: 2020/7/17 16:23
 * @Description: 认识线程
 * 线程 程序执行的最小单元
 * 一个进程中可以有多个线程
 * 多线程可以并发执行
 *
 * 创建线程的方法
 * 第一种方法：继承Thread 类，缺点 只能基础一个类
 * 第二种方法：实现runnable 接口。推荐使用
 */
public class Thread01 extends Thread {

    long minPrime;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public Thread01(long minPrime) {
        this.minPrime = minPrime;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        System.out.println("线程名称:"+this.getName());
        if(1>ThreadTest.ticket){
            System.out.println("票已买完");
            return;
        }
        ThreadTest.ticket --;


    }

    public static void main(String[] args) {
        //实例化继承线程类的字类 将创建一个线程
        Thread01 thread01 = new Thread01(System.currentTimeMillis());
        Thread01 thread02 = new Thread01(System.currentTimeMillis());
        thread01.start();
        thread02.start();

    }
}
