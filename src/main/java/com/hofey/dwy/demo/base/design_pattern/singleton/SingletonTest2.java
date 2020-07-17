package com.hofey.dwy.demo.base.design_pattern.singleton;

/**
 * @Author: hofey
 * @Date: 2020/4/28 13:31
 * @Description:
 */
public class SingletonTest2 {

    //2 定义类变量
    private static final SingletonTest2 INSTANCE = new SingletonTest2();
    //3 提供给外部实例获取方法
    public static SingletonTest2 getInstance(){
        return SingletonTest2.INSTANCE;
    }
    //1,构造方法私有化，不允许外部类调用
    private SingletonTest2(){

    }

    public static void main(String[] args) {
        String a = "http://daoban-click.oss-cn-beijing.aliyuncs.com/guidePlate/268/1\n" +
                "588055034000_%E5%A8%84%E5%85%B5%E5%8F%A3%E8%85%94%E9%97%A8%E8%AF%8A%E9%83%A8%E5%BC%A0%E7%BB%8D%E7%A6%8F.zip";
        System.out.println(a.length());
    }

}


