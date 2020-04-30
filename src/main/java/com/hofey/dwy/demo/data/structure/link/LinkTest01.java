package com.hofey.dwy.demo.data.structure.link;

/**
 * @Author: hofey
 * @Date: 2020/4/29 11:51
 * @Description: 描述
 */
public class LinkTest01 {

    private class Node{
        private Object data;
        private Node next;


        public void addNode(Node node){
            if(this.next==null){
                this.next=node;
            }else {
                this.next.addNode(node);
            }
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
    }

    //创建根节点root
    private Node root;

    /***
     * 添加节点
     * @param data
     */
    public void addNode(Object data){
        if(data == null){
            return;
        }
        Node node  = new Node();
        node.setData(data);
        if (root ==null || root.getData()==null){
            this.root = node;
        }else{
            this.root.addNode(node);
        }
    }

    public static void main(String[] args) {
        LinkTest01 linkTest01 = new LinkTest01();
        linkTest01.addNode("kobe");
        linkTest01.addNode("bryant");
        System.out.println("-----------");
    }
}
















