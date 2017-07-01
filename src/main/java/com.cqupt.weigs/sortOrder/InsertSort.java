package com.cqupt.weigs.sortOrder;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 * @author weigs
 * @date 2017/6/29 0029
 */
public class InsertSort {  
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 45, 6, 34, 32, 2, 1, 1};
        for (int i : a) {
            System.out.print(i + " ");
        }

        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(a);

        System.out.println();
        System.out.println("排序后");
        for (int i : a) {
            System.out.print(i + " ");
        }

    
    }

    public void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {//从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去
            if (a[i] < a[i - 1]) {
                int j;
                int x = a[i];//x为待插入元素
//                a[i] = a[i - 1];
                for (j = i - 1; j >= 0 && x < a[j]; j--) {//通过循环，逐个后移一位找到要插入的位置
                    a[j + 1] = a[j];
                }
                a[j + 1] = x;//插入
            }
        }
    }

}
