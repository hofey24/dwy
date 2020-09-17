package com.hofey.dwy.demo.abstract_demo;

/**
 * @Author: hofey
 * @Date: 2020/4/13 17:18
 * @Description:
 */
abstract  class Person {

    /***
     * 只有抽象类才能有抽象方法
     * 抽象类可以有普通方法
     * 抽象方法没有方法体，普通方法必须有方法体；
     * 字类继承父类,如果父类是抽象类那么必须实现父类的抽象方法
     */
   abstract  void say();
}

class Children extends Person {

    public static void main(String[] args) {
        Children children = new Children();
        children.say();
    }


    /***
     * 只有抽象类才能有抽象方法
     * 抽象类可以有普通方法
     * 抽象方法没有方法体，普通方法必须有方法体；
     * 字类继承父类,如果父类是抽象类那么必须实现父类的抽象方法
     */
    @Override
    void say() {

    }
}

