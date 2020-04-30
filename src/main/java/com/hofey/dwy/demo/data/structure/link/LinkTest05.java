package com.hofey.dwy.demo.data.structure.link;

/**
 * @Author: hofey
 * @Date: 2020/4/30 10:15
 * @Description: 数据结构的最大特性 就是 递归+引用
 * <p>
 * 而 链表的最大特点就是 每次需要判断根节点 ,根节点以后的Node节点递归调用
 */
public class LinkTest05 {


    /***
     * 负责操作数据和管理节点链接
     */
    private class Node {
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
        }

        /***
         * 添加节点
         * @param node
         * this.next  =  this.root.next
         */
        void addNode(Node node) {
            //判断root.next 是否为空
            if (null == this.next) {
                this.next = node;
            } else {
                this.next.addNode(node);
            }
        }

        /***
         * 链表转数组
         */
        void toArrayNode() {
            //将root节点中的数据 保存给数组
            LinkTest05.this.retData[LinkTest05.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }

        /***
         * 判断节点中是否存在某数据
         * 核心方法 equals() .如果是对象比较需要覆写equals方法
         * @param data
         * @return
         *  this.next = this.root.next
         */
        boolean containsData(Object data) {
            if (this.data.equals(data)) {
                return true;
            } else {
                if (this.next != null) {
                        return this.next.containsData(data);
                } else {
                    return false;
                }

            }
        }

        /***
         * 根据索引查询数据
         * @param index
         * @return
         */
        Object getData(int index) {
            if (LinkTest05.this.foot++ == index) {
                return this.data;
            } else {
                return this.next.getData(index);
            }
        }

        /***
         * 修改指定缩影数据
         * @param index
         * @param newData
         */
        void setNode(int index,Object newData){
            if(LinkTest05.this.foot++ == index){
                this.data = newData;
            }else {
                this.next.setNode(index,newData);
            }
        }

        /***
         * 移除节点
         * previous.next = this.next
         * @param previous
         * @param rmData
         */
        void removeNode(Node previous,Object rmData){
            //判断要删除的数据是否是存在当前节点
            if(this.data.equals(rmData)){
                previous.next = this.next;
            }else {
                this.next.removeNode(this,rmData);
            }
        }
    }
    //-----------------------------------------

    //链表操作节点必须有根节点属性
    private Node root;
    //链表长度计数
    private int count = 0;

    private Object[] retData;

    private int foot = 0;

    /***
     * 链表添加数据
     */
    public void addData(Object data) {
        if (data == null) {
            return;
        }
        //将数据封装为node节点，因为 节点负责操作数据和管理节点链接
        Node node = new Node(data);
        /***
         * 就想排队一样，首先需要判断第一个。也就是根节点.
         */
        if (null == this.root) {
            this.root = node;
        } else {
            /***
             * 向后排。因为 节点链接由 node管理。
             */
            this.root.addNode(node);
        }
        count++;
    }

    /***
     * 获取链表长度
     * @return
     */
    public int size() {
        return this.count;
    }

    /***
     * 链表转数组
     * @return
     */
    public Object[] toArray() {
        /***
         * 根据链表根节点，递归取出所有节点中的数据并保存到数组当中
         */
        //定义数组;长度为当前链表长度
        retData = new Object[count];
        this.foot=0;
        //将节点中保存的数据让如retData中。
        this.root.toArrayNode();
        return retData;
    }

    /***
     * 是否空链表
     * @return
     */
    public boolean isEmpty() {
        return this.count == 0 && this.root == null;
    }

    /***
     * 查询某数据是否存在链表中
     * @param data
     * @return
     */
    public boolean contains(Object data) {
        if (null == data) {
            return false;
        }
        if (this.root == null || this.count == 0) {
            return false;
        } else {
            return this.root.containsData(data);
        }
    }

    /***
     * 根据索引查询数据
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index >= count) {
            return null;//实际进行异常处理
        } else {
            this.foot = 0;//foot 清零
            return this.root.getData(index);
        }
    }

    /***
     * 修改指定索引值数据
     * @param index
     * @param data
     */
    public void set(int index , Object data){
        if(index >= count){
            return;
        }else {
            this.foot = 0;
            this.root.setNode(index,data);
        }

    }

    /***
     * 移除数据
     * 关键点：
     * （1）如果是移除根节点,
     *      那么根节点移除后 ，根节点如果有下一个节点。那么下一个节点前移，代替根节点。原来的根节点
     * 没有引用指向，将被垃圾回收器收回。
     * （2）如果移除对象存在于子节点
     *  移除子节点需要交由Node类处理；子节点移除,其实就是将 该节点的上一个节点的next 指向 该节点的next.
     *  也就是类似 火车 去掉一节车厢，那么 原来挂在该车厢的连接点自然而然的要前进一个车厢为，挂在该车厢的前一个
     *  车厢。this.pervious.next = this.next;
     * @param data
     */
    public void remove(Object data){
        //判断当前数据是否存在链表中
        if(this.contains(data)){
            //判断当前数据是否存在根节点中
            if(this.root.data.equals(data)){
                if(this.root.next!=null){
                    this.root = this.root.next;//将根节点的下一个节点 替换 根节点
                }
            }else {
                this.root.next.removeNode(this.root,data);
            }
            count --;
        }
    }
    /***
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LinkTest05 linkTest05 = new LinkTest05();
        System.out.println(linkTest05.size());
        linkTest05.addData("kobe");
        linkTest05.addData("bryant");
        linkTest05.addData("hofey");
        System.out.println(linkTest05.size());
        Object[] objects = linkTest05.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i] + " ");
        }
       /* System.out.println(linkTest05.contains("kobe"));
        System.out.println(linkTest05.get(0));

        linkTest05.set(1,"test");*/


       //--------------------------
        System.out.println("=========================");
        linkTest05.remove("hofey");
        Object[] objects2 = linkTest05.toArray();
        for (int i = 0; i < objects2.length; i++) {
            System.out.println(objects2[i] + " ");
        }
    }
}
