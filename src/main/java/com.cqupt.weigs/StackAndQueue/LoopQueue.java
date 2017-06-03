package com.cqupt.weigs.StackAndQueue;

import java.util.Arrays;

/**
 * 循环队列
 *
 * @author weigs
 * @date 2017/6/3 0003
 */
public class LoopQueue<T> {
    private int DEFAULT_SIZE = 10;

    //保存数组长度
    private int capacity;

    //定义一个数组用于保存循环队列中的元素
    private Object[] elementData;

    //队头
    private int front = 0;

    //队尾
    private int rear;

    //以默认数组长度创建空循环队列
    public LoopQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素来创建循环队列
    public LoopQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    //以指定长度的数组来创建循环队列
    public LoopQueue(T element, int initsize) {

        capacity = initsize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    //获取循环队列的大小
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear > front ? rear - front : capacity - (front - rear);
    }

    //插入
    public void add(T element) {
        if (rear == front && elementData[front] != null) {
            throw new IndexOutOfBoundsException("队列已满异常");
        }
        elementData[rear++] = element;
        //如果rear已经到头，那就转头
        rear = rear == capacity ? 0 : rear;
    }

    //移除队列
    public T remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        //保留队列的rear端的元素的值
        T oldValue = (T) elementData[front];
        //释放队列的rear端的元素
        elementData[front++] = null;
        //如果front到头，那就转头
        front = front == capacity ? 0 : front;
        return oldValue;
    }

    //返回队列顶元素，但是不删除元素
    public T element() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }

    //判断循环队列是否为空
    public boolean isEmpty() {
        //rear==front且rear处的元素为null
        return rear == front && elementData[rear] == null;
    }

    //清空循环队列
    public void clear() {
        //将底层数组的所有元素赋为null
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            //如果front < rear，有效元素就是front到rear之间的元素
            if (front < rear) {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < rear; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
            //如果front >= rear，有效元素为front->capacity之间、0->front之间的
            else {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                for (int i = 0; i < rear; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
        }
    }

    public static void main(String[] args) {
        LoopQueue<String> queue = new LoopQueue<>("aaa",3);
        queue.add("bbb");
        queue.add("ccc");
        //此时队列已经满了
        System.out.println(queue);
        queue.remove();
        System.out.println("删除一个元素后的队列："+queue);
        queue.add("ddd");
        System.out.println(queue);
        System.out.println("队列满时长度："+queue.size());
    }

}
