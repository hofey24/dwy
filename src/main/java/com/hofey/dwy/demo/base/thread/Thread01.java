package com.hofey.dwy.demo.base.thread;

/**
 * @program: dwy
 * @description: 线程学习，了解Thread类 继承 Thread 类创建线程 并启动线程
 * @author: yhf
 * @create: 2021-02-20 21:12
 **/
public class Thread01 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <10 ; i++) {
            System.out.println("当前线程名称"+this.getName()+" 当前循环次数："+(i+1));
        }

    }

    public static void main(String[] args) {
/*        Thread thread = Thread.currentThread();
        System.out.println("当前线程的名称："+thread.getName());
        System.out.println("当前线程的优先级"+thread.getPriority());

        thread.setPriority(9);
        thread.setName("mainnew");
        System.out.println("当前线程的名称:"+thread.getName()+" ;当前线程的优先级:"+thread.getPriority());*/



        Thread01 thread01 = new Thread01();
        thread01.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println("当前线程名称"+Thread.currentThread().getName()+" 当前循环次数："+(i+1));
        }
    }

}
