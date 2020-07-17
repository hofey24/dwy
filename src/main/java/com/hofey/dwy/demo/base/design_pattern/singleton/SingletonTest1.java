package com.hofey.dwy.demo.base.design_pattern.singleton;

/**
 * @Author: hofey
 * @Date: 2020/4/15 16:54
 * @Description: 单例模式联系第一遍
 */
public class SingletonTest1 {
    /***
     * 普通 饿汉模式
     */
   //1.将构造方法自由化，使外部不可实例化对象.只有类内部可以实例化对象

    private SingletonTest1() {
    }
    // 2,创建静态变量，在类加载时候便实例化对象 并使用final修饰，使类变量不可修改
    private final static SingletonTest1 INSTANCE = new SingletonTest1();
    //3,由于类属性一般为私有属性，需要提供对外获取对象的方法
    public static SingletonTest1 getInstance(){
        return INSTANCE;
    }
}

