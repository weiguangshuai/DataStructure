package com.cqupt.weigs.StackAndQueue;

/**
 * 链式队列
 *
 * @author weigs
 * @date 2017/6/3 0003
 */
public class LinkQueue<T> {
    //定义一个内部类Node，Node实例代表链队列的节点
    class Node {
        //保存节点的数据
        private T date;

        //指向下个节点的引用
        private Node next;

        //无参构造器
        public Node() {
        }

        //初始化全部属性的构造器
        public Node(T date, Node next) {
            this.date = date;
            this.next = next;
        }

    }

    //保存该链队列的头节点
    private Node front;

    //保存该链队列的尾节点
    private Node rear;

    //保存该链队列已经包含的节点数
    private int size;

    //创建空链队列
    public LinkQueue() {
        //空链队列，都是null
        front = null;
        rear = null;
    }

    //以指定数据元素来创建链队列，该链队列只有一个元素
    public LinkQueue(T element) {
        front = new Node(element, null);
        //只有一个节点，front、rear都指向该节点
        rear = front;
        size++;
    }

    //获取顺序队列的大小
    public int size() {
        return size;
    }

    //入队
    public void offer(T element) {
        //该队列还是空队列
        if (front == null) {
            front = new Node(element, null);
            rear = front;//只有一个节点，front、rear都指向这个节点

        } else {
            Node newNode = new Node(element, null);
            //让尾节点的next指向新增的节点
            rear.next = newNode;
            //以新节点作为尾节点
            rear = newNode;
        }
        size++;
    }

    //出队
    public T poll() {
        Node oldFront = front;
        front = front.next;
        oldFront.next = null;
        size--;
        return oldFront.date;
    }

    //返回队列顶元素，但不删除队列顶元素
    public T peek() {
        return front.date;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //清空顺序队列
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = front; current != null; current = current.next) {
                sb.append(current.date.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }


    public static void main(String[] args) {
        LinkQueue<String> queue = new LinkQueue<>("aaa");
        queue.offer("bbbb");
        queue.offer("cccc");
        queue.offer("ddd");
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        queue.offer("aaa");
        System.out.println(queue);

        queue.clear();
        System.out.println(queue);
    }
}

