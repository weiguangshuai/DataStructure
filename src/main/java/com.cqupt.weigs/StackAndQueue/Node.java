package com.cqupt.weigs.StackAndQueue;

/**
 * @author weigs
 * @date 2017/7/31 0031
 */
public class Node<T> {
    T data;
    Node next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
