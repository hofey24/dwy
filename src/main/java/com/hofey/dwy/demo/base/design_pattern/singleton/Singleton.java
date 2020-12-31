package com.hofey.dwy.demo.base.design_pattern.singleton;

/**
 * @Author: hofey
 * @Date: 2020/4/15 15:19
 * @Description:
 *  1,什么是单例模式?
 *  单例模式是指java容器中,某个类只存在一个实例化对象
 *  2,为什么使用单例模式
 *  比如说我们在系统运行时候，就需要加载一些配置和属性，这些配置和属性是一定存在了，
 *  又是公共的，同时需要在整个生命周期中都存在，所以只需要一份就行，这个时候如果需要
 *  我再需要的时候new一个，再给他分配值，
 *  显然是浪费内存并且再赋值没什么意义，所以这个时候我们就需要单例模式或静态方法去维持
 *  一份且仅这一份拷贝，但此时这些配置和属性又是通过面向对象的编码方式得到的，
 *  我们就应该使用单例模式，或者不是面向对象的，但他本身的属性应该是面对对象的，
 *  我们使用静态方法虽然能同样解决问题，但是最好的解决方案也应该是使用单例模式。
 *
 */
class Singleton {
    //1,正常来说,普通类如果没有显式构造方法，那么该对象会有一个默认的构造方法。
    //2,如果将对象的构造方法改为private,那么外部创建对象则会报错
    private static final Singleton INSTANCE = new Singleton();
    public static Singleton getInstance(){
        return INSTANCE;
    }
    private  Singleton() { }
}

/**
 * @Author: hofey
 * @Date: 2020/4/15 16:09
 * @Description: 懒汉式单例模式
 *  在第一次获取对象的时候再进行对象实例化操作
 */
class LazySingleton{
    private  static LazySingleton instance = null;
    public static LazySingleton getInstance(){
        if(instance == null){
            return instance = new LazySingleton();
        }else {
            return instance;
        }

    }
    private  LazySingleton() { }
}

