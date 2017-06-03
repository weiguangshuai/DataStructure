package com.cqupt.weigs.linearTable;

import java.util.Arrays;

/**
 * @author weigs
 * @date 17-5-11
 * 线性表顺序存储结构
 */
public class SequenceList<T> {

    private static int DEFAULT_SIZE = 16;
    //保存数组的长度
    private int capacity;
    //定义一个数组用于保存顺序线性表的元素
    private Object[] elementData;
    //保存顺序表中元素的当前个数
    private int size;
    //以默认数组长度创建空顺序线性表
    public SequenceList() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }
    //以一个初始化元素来创建顺序线性表
    public SequenceList(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    /**
     * 以指定长度的数组来创建顺序线性表
     */
    public SequenceList(T element, int initsize) {
        capacity = 1;
        //把capacity设置为大于initsize的最小的2的n次方
        while (capacity < initsize) {
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //获取顺序线性表的大小
    public int length() {
        return size;
    }

    //获取线性表中索引为i的元素
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        return (T)elementData[i];
    }

    //查找线性表中指定元素的索引
    public int locate(T element) {
        for (int i = 0; i < size; i++){
            if (elementData[i].equals(element))
                return i;
        }
        return -1;
    }

    //向顺序线性表中的指定位置插入一个元素
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        //将index后的所有元素向后移一格
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    //向线性表中添加一格元素
    public void add(T element) {
        insert(element, size);
    }

    //删除顺序线性表中指定索引的元素
    public T delete(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("线性表索引越界");
        T oldValue = (T)elementData[index];
        int num = size - index - 1;
        if (num > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, num);
        }
        //清空最后一个元素
        elementData[--size] = null;
        return oldValue;

    }

    //删除顺序表中最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    //判断顺序线性表是否为空
    public boolean empty() {
        return size == 0;
    }

    //清空线性表
    public void clear() {
        Arrays.fill(elementData, null);
    }
}
