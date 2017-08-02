package com.cqupt.weigs.Link;

/**
 * @author weigs
 * @date 2017/7/26 0026
 */
public class SeqList<T> implements ISeqList<T> {

    private Object[] table;
    private int length;

    public SeqList(int capacity) {
        this.table = new Object[capacity];
        this.length = 0;
    }

    public SeqList() {
        this(64);
    }


    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < this.length)
            return (T) table[index];
        return null;
    }

    //返回被替换的值
    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T data) {
        if (index >= 0 && index < this.length && data != null) {
            T old = (T) this.table[index];
            this.table[index] = data;
            return old;
        }
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        if (data == null)
            return false;
        //插入下表容错判断
        if (index < 0)
            index = 0;
        if (index > this.length)
            index = this.length;

        //判断数组是否已满
        if (table.length == this.length) {
            Object[] tmp = new Object[table.length];
            this.table = new Object[length * 2];
            for (int i = 0; i < length; i++) {
                table[i] = tmp[i];
            }
        }

        for (int j = this.length - 1; j >= index; j--) {
            this.table[j + 1] = this.table[j];
        }
        this.table[index] = data;
        length++;
        return true;
    }

    @Override
    public boolean add(T data) {
        return add(this.length, data);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (this.length != 0 && index >= 0 && index < this.length) {
            //记录删除元素的值并返回
            T old = (T) table[index];
            for (int j = index; j < length - 1; j++) {
                table[j] = table[j + 1];
            }
            //设置数组元素对象为空
            table[length - 1] = null;
            length--;
            return old;
        }

        return null;
    }

    @Override
    public boolean remove(T data) {
        if (this.length != 0 && data != null)
            return this.remove(indexOf(data)) != null;
        return false;
    }

    @Override
    public boolean removeAll(T data) {
        boolean done = false;
        if (this.length != 0 && data != null) {
            int i = 0;
            while (i < this.length) {
                if (data.equals(table[i])) {
                    remove(i);
                    done = true;
                } else {
                    i++;
                }
            }
        }
        return done;
    }

    @Override
    public void clear() {
        this.length = 0;
    }

    @Override
    public boolean contains(T data) {
        return this.indexOf(data) >= 0;
    }

    @Override
    public int indexOf(T data) {
        if (data != null) {
            for (int i = 0; i < this.length; i++) {
                if (this.table[i].equals(data))
                    return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(T data) {
        if (data != null) {
            for (int i = this.length - 1; i >= 0; i--) {
                if (table[i].equals(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void print() {
        for (Object o : table) {
            if (o != null) {
                System.out.print(o + " ");
            }
        }
    }
}
