package com.cqupt.weigs.StackAndQueue;

/**
 * @author weigs
 * @date 2017/7/31 0031
 */
public class LinkedStack<T> {
    private Node<T> top;

    private int size;

    public LinkedStack() {
        this.top = new Node<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null || top.data == null;
    }

    public void push(T data) {
        if (top == null) {
            this.top = new Node<>(data);
        } else if (this.top.data == null) {
            this.top.data = data;
        } else {
            Node<T> p = new Node<>(data, this.top);
            top = p;
        }
        size++;
    }

    public T peek() {
        return top.data;
    }

    public T pop() {
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

}
