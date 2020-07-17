package com.hofey.dwy.demo.base.data.structure.link;

/**
 * @Author: hofey
 * @Date: 2020/4/28 16:59
 * @Description: 链表操作类
 */
public class Link {
    //创建内部类，访问方法私有 只允许Link类调用
    private class Node {
        //node 有两个属性 data 和 next ；其中data为数据存储，next 用来指向下一个节点
        private Object data;
        private Node next;

        //创建有参构造方法
        public Node(Object data) {
            this.data = data;
        }

        /***
         * 添加节点
         * @param node
         */
        public void addNode(Node node) {
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.addNode(node);
            }
        }
    }

    //---------------------------------
    //由Link来操作节点，但是节点 链接由node自己控制
    private Node root;
    private int count;
    /***
     * 节点添加逻辑
     * 1,参数为Object,入参需封装为Node;
     * 2,先判断root 节点，如果root节点为空，那么该节点为root节点；否则找下一个节点
     * 3,如果下一个节点也不为空，那么就循环继续；注：所有的数据结构都是递归+引用
     * @param data
     */
    public void addNode(Object data) {
        if (data == null) {
            return;
        }
        Node newNode = new Node(data);
        if (root == null || root.data == null) {//说明没有root节点
            this.root = newNode;
        } else {
            //添加节点；由node自己控制
            this.root.addNode(newNode);
        }
        this.count++;
    }
    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Link link = new Link();
        System.out.println(link.getCount());
        link.addNode("hello");
        link.addNode("world");
        link.addNode(1);
        link.addNode(2);
        link.addNode("kobe");
        link.addNode("bryant");
        System.out.println(link.getCount());

    }

}
