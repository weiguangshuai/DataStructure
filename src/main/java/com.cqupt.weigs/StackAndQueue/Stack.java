package com.cqupt.weigs.StackAndQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weigs
 * @date 2017/5/22 0022
 */
public class Stack<E extends Object> {
    private List<E> pool = new ArrayList<>();

    public Stack(int length) {

    }

    public void clear() {
        pool.clear();
    }

    public boolean isEmpty() {
        return pool.isEmpty();
    }

    /**
     * 获取栈顶元素
     */
    public E getTopObject() {
        if (isEmpty()) {
            return null;
        }

        return pool.get(pool.size() - 1);
    }

    /**
     * 弹出栈操作
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return pool.remove(pool.size() - 1);
    }

    /**
     * 压入栈
     */
    public void push(E e) {
        pool.add(e);
    }

    /**
     * 获取当前栈大小
     */
    public int getStackSize() {
        if (isEmpty()) {
            return 0;
        }
        return pool.size();
    }
}
