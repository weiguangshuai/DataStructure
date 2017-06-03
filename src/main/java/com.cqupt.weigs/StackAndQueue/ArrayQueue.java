package com.cqupt.weigs.StackAndQueue;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 顺序队列
 *
 * @author weigs
 * @date 2017/6/3 0003
 */
public class ArrayQueue<T> {
    private int DEFAULT_SIZE = 10;

    //保存数组的长度
    private int capacity;

    //定义一个数组用于保存顺序队列的元素
    private Object[] elementData;

    //队头
    private int front = 0;

    //队尾
    private int rear = 0;

    //以默认数组长度创建空顺序队列
    public ArrayQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素来创建顺序队列
    public ArrayQueue(T t) {
        this();
        elementData[0] = t;
        rear++;
    }

    public ArrayQueue(int initsize) {
        elementData = new Object[initsize];
    }

    //以指定长度的数组来创建顺序队列
    public ArrayQueue(T t, int initsize) {

        this.capacity = initsize;
        elementData = new Object[capacity];
        elementData[0] = t;
        rear++;
    }

    //获取顺序队列的大小
    public int size() {
        return rear - front;
    }

    //入队
    public void offer(T element) {

        ensureCapacity(rear + 1);
        elementData[rear++] = element;
    }

    //如果数组的原有长度小于目前所需的长度
    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    //出队
    public T poll() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        //保留队列的front端的元素的值
        T oldValue = (T) elementData[front];
        //释放队列的front端的元素
        elementData[front++] = null;
        return oldValue;
    }

    //返回队列顶元素，但不删除队列顶元素
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }

    //判断顺序队列是否为空队列
    public boolean isEmpty() {
        return rear == front;
    }

    //清空顺序队列
    public void clear() {
        //将底层所有元素赋为null
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = front; i < rear; i++) {
                stringBuilder.append(elementData[i].toString()+",");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 1,len).append("]").toString();
        }
    }
}
