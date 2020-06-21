package com.hofey.dwy.demo.data.structure.link;

/**
 * @program: dwy
 * @description: 链表学习06
 * @author: yhf
 * @create: 2020-05-02 08:43
 **/
public class LinkTest06 {
    /***
     * 创建节点类，只允许Link类访问及操作
     */
    private class Node {
        /***
         * 节点负责存储数据 和 维护节点关系 所以有 data 和 next 属性
         */
        private Object data;
        private Node next;

        /***
         * 定义有参数构造方法 ，方便存储值
         */
        public Node(Object data) {
            this.data = data;
        }

        /***
         * 添加节点方法
         * 所有的数据结构都是递归+引用传递
         * 而 递归的核心就是方法自调用及控制结束点
         * @param node
         */
        public void addNode(Node node) {
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.addNode(node);
            }
        }

        /***
         * 节点转数组
         */
        public void toArrayNode() {
            //首先将根节点的data赋予数组
            LinkTest06.this.retData[LinkTest06.this.foot++] = this.data;
            //判断如果子节点不为空，则迭代执行。这也就明白了 foot 的作用
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }

        /***
         * 数据是否存在
         * @param data
         * @return
         */
        public boolean containsNode(Object data) {
            if (this.data.equals(data)) {
                return true;
            } else {
                if (this.next == null) {
                    return false;
                } else {
                    return this.next.containsNode(data);
                }
            }
        }

        /***
         * 获取指定索引数据
         * @param index
         * @return
         */
        public Object getData(int index){
            if(LinkTest06.this.foot ++ == index){
                return this.data;
            }else {
                return this.next.getData(index);
            }
        }

        /***
         * 删除节点，删除的节点没有被引用 则将被垃圾回收器回收
         * @param data
         *  this = this.root.next
         */
        public void removeNode(Node previous,Object data){
            if(this.data.equals(data)){
                previous.next=this.next;
            }else {
                this.next.removeNode(this,data);
            }
        }
    }

    /****************************************************************************
     * ****************************************************************************
     * ****************************************************************************
     */


    private Node root;//所有节点操作都是从根节点开始


    private int count = 0;

    private Object[] retData;//用于接收返回值
    private int foot = 0; //定义脚标

    /***
     * 保存数据方法
     */
    public void add(Object data) {
        if (data == null) {
            return;
        }
        //将入参封装为节点；因为链表和节点类 操作的都是Node节点
        Node node = new Node(data);
        /***
         * 判断是否是根节点，如果不是则交由node类存储数据并处理节点关系
         */
        if (root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
        count++;
    }

    /***
     * 返回链表长度
     * @return
     */
    public int size() {
        return this.count;
    }

    /***
     * 判断是否空链表
     * @return
     */
    public boolean isEmpty() {
        return size() == 0 && this.root == null;
    }

    /***
     * 链表转数组/查询数据
     * 怎样转数组呢，当然是递归链表节点，将每个节点存储的data赋值给数组
     *
     */
    public Object[] toArray() {
        if (this.isEmpty()) {
            return null;
        }
        //定义数组，并制定数组长度为链表的长度
        this.retData = new Object[this.count];
        //脚标清零，链表每次调用toArray方法都需要将脚标清零
        this.foot=0;
        /***
         * 在node类中定义 toArray方法
         */
        this.root.toArrayNode();
        return retData;
    }

    /***
     * 判断数据是否存在
     * 实现原理：
     * 利用equals方法,这就需要入参data 覆写 equals方法
     *
     */
    public boolean contains(Object data) {
        if (data == null) {
            return false;
        }
        if (this.isEmpty()) {
            return false;
        } else {
            return this.root.containsNode(data);
        }
    }

    /***
     * 因为链表也是线性结构，每个节点都有其索引
     * 返回指定索引的值
     * @return
     */
    public Object get(int index){
        if(index>=this.size()){
            return null;//其实应该抛出异常
        }
        if(this.isEmpty()){
            return null;
        }else {
            this.foot=0;
            return this.root.getData(index);
        }
    }

    /***
     * 删除指定数据
     * 关键点：
     * 1,如果删除的是根节点，那么根节点的下一个基点将代替根节点 也就是 this.root = this.root.next;
     * 2,如果删除的是普通节点，那么当前节点的前一个节点的next将指向当前节点的next;
     */
    public void remove(Object data){
        if(!contains(data)){
            return;
        }
        if(this.root.data.equals(data)){
            this.root = this.root.next;
        }else {
            if(this.root.next!=null){
                this.root.next.removeNode(this.root,data);
            }else {
                return;
            }

        }
        count--;
    }


    public static void main(String[] args) {
        LinkTest06 link = new LinkTest06();
        link.add("hello");
        link.add("world");
        link.add("kobe");
        link.add("bryant");
        link.add("hofey");
        System.out.println(link.count);
        Object[] objects = link.toArray();
        for (int i = 0; i <objects.length ; i++) {
            System.out.print(objects[i]+" ");
        }
        System.out.println("/n");
        System.out.println(link.get(2));
        System.out.println(link.contains("hofey1"));

        link.remove("hofey");
        Object[] objects2 = link.toArray();
        for (int i = 0; i <objects2.length ; i++) {
            System.out.print(objects2[i]+" ");
        }


    }
}
