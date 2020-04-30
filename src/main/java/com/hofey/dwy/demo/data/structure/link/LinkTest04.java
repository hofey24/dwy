package com.hofey.dwy.demo.data.structure.link;

/**
 * @Author: hofey
 * @Date: 2020/4/29 15:46
 * @Description:
 */
public class LinkTest04 {
    private int count;
    private Node root;//设置根节点属性 链表结构必须有根节点


    private Object[] retData;
    private int foot= 0;

    /***
     * 添加数据
     * @param data
     */
    public void addNode(Object data){
        if(data ==null ){
            return;
        }
        Node node = new Node(data);//数据必须封装成Node.然后由链表类来操作节点
        if(this.root ==null){
            this.root = node;
        }else {
            this.root.addNode(node);
        }
        count++;
    }

    /***
     * 链表的节点长度
     * @return
     */
    public int size(){
        return this.count;
    }

    /***
     * 链表转数组；获取链表数据
     * @return
     */
    public Object[] toArray(){
        //判断链表长度是否为0；
        if(this.size()<1){
            return null;
        }
        //开辟数组用于接受返回结果，数组长度为链表长度
        retData = new Object[this.size()];
        //每次调用方法需要清零下标；
        this.foot=0;
        //从根节点开始，递归获取节点中的数据并付给数组
        this.root.toArray();
        return retData;
    }

    /***
     * 链表中是否存在某对象
     * @param data
     * @return
     */
    public boolean contains(Object data){
        if(count==0||data==null){
            return false;
        }
        return this.root.contains(data);

    }

    private class Node{
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
        }
        /***
         * 添加节点
         * 数据结构的根本：递归+引用
         * 递归方法特点，有结束条件+子调用
         * 第一次调用 this = Link.root;
         * 第二次调用 this.next = link.root.next;
         * 。。。
         */
        void addNode(Node node){
            if (this.next== null){
                this.next=node;
            }else {
                this.next.addNode(node);
            }
        }

        /***
         * 链表转数组，从跟节点开始，递归获取节点中的数据复制给数组
         * 第一次调用 this.data = Link.root.data;从根节点开始
         */
        void toArray(){
            LinkTest04.this.retData[LinkTest04.this.foot++] = this.data;
            if(this.next!=null){
                this.next.toArray();
            }
        }

        /***
         * 查询链表中是否存在某数据
         * @param data
         * @return
         */
        boolean contains(Object data){
           if(this.data.equals(data)){
               return true;

           }else {
               if (this.next == null) {
                   return false;
               }else
                   return this.next.contains(data);
           }

        }
    }

    public static void main(String[] args) {
        LinkTest04 test04 = new LinkTest04();
        System.out.println(test04.size());
        test04.addNode("hello");
        test04.addNode("world");
        test04.addNode("kobe");
        test04.addNode("bryant");
        test04.addNode("hofey");
        System.out.println(test04.size());


        Object[] arr = test04.toArray();
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(test04.contains("hello"));
    }
}
