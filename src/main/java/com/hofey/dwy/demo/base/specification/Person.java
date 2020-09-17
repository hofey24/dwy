package com.hofey.dwy.demo.base.specification;

import lombok.Data;

import java.util.Arrays;

/**
 * @Author: hofey
 * @Date: 2020/8/17 10:34
 * @Description:
 */
@Data
public class Person<T,A> implements Comparable<Person> {
    private T  name;
    private Integer age;

    public static void main(String[] args) {
        Person<String,Object> a  = new Person<>();
        a.setName("张三");
        a.setAge(11);
        Person<Integer,Object> b  = new Person<>();
        b.setName(12);
        b.setAge(24);
        Person<Integer,Object> c  = new Person<>();
        c.setName(14);
        c.setAge(14);
        Person[] people = new Person[]{a,b,c};
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }



    @Override
    public int compareTo(Person o) {
        if(o.getAge()>this.age){
            return -1;
        }else if(o.getAge()<this.age) {
            return 1;
        }
        return 0;
    }
}
