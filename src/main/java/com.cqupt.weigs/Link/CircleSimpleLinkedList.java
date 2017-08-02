package com.cqupt.weigs.Link;

/**
 * 循环单链表
 *
 * @author weigs
 * @date 2017/7/27 0027
 */
public class CircleSimpleLinkedList<T> {
    protected Node<T> head;//不带数据头节点
    protected Node<T> tail;//指向尾部的指针

    public CircleSimpleLinkedList() {
        //初始化头节点和尾指针
        this.head = new Node<>(null, null);
        this.head.next = head;
        this.tail = head;
    }

    public CircleSimpleLinkedList(T[] array) {
        this();
        if (array != null && array.length > 0) {
            this.head.next = new Node<>(array[0], head);
            tail = this.head.next;
            int i = 1;
            while (i < array.length) {
                tail.next = new Node<>(array[i++], null);
                tail.next.next = head;
                tail = tail.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head.next == head;
    }

    public int length() {
        int length = 0;
        Node<T> p = this.head.next;
        while (p != head) {
            p = p.next;
            length++;
        }
        return length;
    }

    public T get(int index) {
        if (index >= 0) {
            int j = 0;
            Node<T> pre = this.head.next;
            while (pre != null && j < index) {
                j++;
                pre = pre.next;
            }
            if (pre != null)
                return pre.data;
        }
        return null;
    }

    public T set(int index, T data) {
        if (data==null){
            return null;
        }

        if(index>=0){
            int j=0;
            Node<T> p=this.head.next;

            while (p!=head&&j<index){
                j++;
                p=p.next;
            }

            //如果不是头结点
            if(p!=head){
                T old = p.data;
                p.data=data;

                return old;
            }
        }
        return null;
    }
}
