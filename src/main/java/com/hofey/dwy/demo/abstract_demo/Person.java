package com.hofey.dwy.demo.abstract_demo;

/**
 * @Author: hofey
 * @Date: 2020/4/13 17:18
 * @Description:
 */
abstract public class Person {


   abstract  void say();
}

class Children extends Person {

    public static void main(String[] args) {
        Children children = new Children();
        children.say();
    }

    @Override
    void say() {

    }
}

