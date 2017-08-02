package com.cqupt.weigs.StackAndQueue;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * 链式队列的实现
 *
 * @author weigs
 * @date 2017/8/2 0002
 */
public class LinkedQueue<T> implements Queue<T>, Serializable {

    private static final long serialVersionUID = -5102575184802625337L;

    /**
     * 指向队头和队尾的节点
     * front==null&&rear==null时，队列为空
     */
    private Node<T> front, rear;

    private int size;

    /**
     * 用于控制最大容量
     */
    private int maxSize;

    public LinkedQueue() {
        this.front = this.rear = null;
    }

    @Override
    public int size() {
        return size;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public boolean add(T data) {
        Node<T> q = new Node<>(data, null);
        if (this.front == null) {
            this.front = q;
        } else {
            this.rear.next = q;
        }
        this.rear = q;
        size++;
        return true;
    }

    @Override
    public boolean offer(T data) {
        if (data == null) {
            throw new NullPointerException("the data can't be null");
        }
        if (size >= maxSize) {
            throw new IllegalArgumentException("the capacity of LinkedQueue has reached his maxSize");
        }

        Node<T> q = new Node<>(data, null);
        if (this.front == null) {
            this.front = q;
        } else {
            this.rear.next = q;
        }
        rear = q;
        size++;
        return true;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : this.front.data;
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException("The LinkedQueue is empty");
        }
        return this.front.data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T t = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        size--;
        return t;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("the queue is empty");
        }
        T t = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        size--;
        return t;
    }

    @Override
    public void clearQueue() {
        this.front = this.rear = null;
        size = 0;
    }
}
