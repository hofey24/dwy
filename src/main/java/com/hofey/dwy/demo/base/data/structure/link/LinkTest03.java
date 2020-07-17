package com.hofey.dwy.demo.base.data.structure.link;

/**
 * @Author: hofey
 * @Date: 2020/4/29 14:23
 * @Description:
 */
public class LinkTest03 {

    private Node root;


    private int count = 0;

    private Object[] retData;//用于接受 node 的值
    private int foot =0;
    public void addNode(Object data) {
        if (data == null) {
            return;
        }
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
        count++;
    }
    public Object[] toArray(){
        //如果为空链表，则直接返回null
        if(this.count==0){
            return null;
        }
        //创建数组并指定数组长度
        retData = new Object[count];
        //数组下标清零
        this.foot=0;
        //node 转为数组，从root节点递归给数组赋值
        this.root.toArrayNode();
        return retData;
    }


    private class Node {
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
        }

        void addNode(Node node) {
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.addNode(node);
            }
        }

        void toArrayNode(){
            LinkTest03.this.retData[LinkTest03.this.foot++] = this.data;
            if(this.next!=null){
                this.next.toArrayNode();
            }
        }



    }

    public static void main(String[] args) {
        LinkTest03 linkTest03 = new LinkTest03();
        linkTest03.addNode("hello");
        linkTest03.addNode("kobe");
        Object[] array = linkTest03.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
