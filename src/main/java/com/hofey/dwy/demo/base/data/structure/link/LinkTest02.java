package com.hofey.dwy.demo.base.data.structure.link;

/**
 * @Author: hofey
 * @Date: 2020/4/29 13:43
 * @Description: 手写链表结构及增加节点功能
 */
public class LinkTest02 {

    private Node root;//创建根节点
    private int count;

    /***
     * 返回节点数量
     * @return
     */
    public int size() {
        return this.count;
    }

    /***
     * 判断是否空链表
     * @return
     */
    public boolean isEmpty(){
        return this.root==null && this.count==0;
    }
    public void addNode(Object data) {
        if (null == data) { //数据为空
            return;
        }
        //将数据 封装节点
        Node node = new Node(data);
        if (null == this.root) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
        count++;
    }

    public static void main(String[] args) {
        LinkTest02 linkTest02 = new LinkTest02();

        System.out.println(linkTest02.size());
        linkTest02.addNode("hello");
        linkTest02.addNode("world");
        linkTest02.addNode("kobe");
        linkTest02.addNode("bryant");
        linkTest02.addNode("hofey");
        System.out.println(linkTest02.size());


    }

    //创建内部 节点类 仅供Link类调用
    private class Node {
        //node类负责 保存数据及节点链接
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        /*
            增加节点的方法。在root节点之后
         */
        public void addNode(Node node) {
            if (this.next == null) {
                this.next = node;
            } else {
                //数据结构都是递归+引用
                this.next.addNode(node);
            }
        }

    }
}
