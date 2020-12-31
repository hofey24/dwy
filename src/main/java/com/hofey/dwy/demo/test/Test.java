package com.hofey.dwy.demo.test;

import java.util.Random;

/**
 * @Author: hofey
 * @Date: 2020/5/29 10:31
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Random rd = new Random();
        for (int i = 0; i <10 ; i++) {
            System.out.println(rd.nextInt(100));
        }

    }
}
