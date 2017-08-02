package com.cqupt.weigs.Link;

/**
 * 链表节点
 * @author weigs
 * @date 2017/7/27 0027
 */
public class Node<T> {
    public T data;//数据域
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
