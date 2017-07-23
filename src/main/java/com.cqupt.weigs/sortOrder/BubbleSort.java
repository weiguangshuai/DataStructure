package com.cqupt.weigs.sortOrder;

import java.util.Random;

/**
 * 冒泡排序
 *
 * @author weigs
 * @date 2017/7/3 0003
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            a[i] = random.nextInt();
        }
        long begin = System.currentTimeMillis();
        bubbleSort2(a);
        long end = System.currentTimeMillis();
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(end - begin);
    }

    //冒泡排序相当于是每次遍历将遍历的数中最大的放在最小面，第一次遍历n-1次，
    // 将最大的放在最后一位，第二次遍历剩下的数，遍历n-2次，将最大的放在倒数第二位，依次类推
    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] + a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] = a[j] - a[j + 1];
                }
            }
        }
    }

    //传统冒泡排序每一次只能找到一个最大值或最小值，现在是进行正向和反向两遍冒泡排序
    public static void bubbleSort2(int a[]) {
        int low = 0;
        int high = a.length - 1;//设置变量的初始值
        while (low < high) {
            for (int i = low; i < high; i++) {//正向冒泡，找最大值
                if (a[i] > a[i + 1]) {
                    a[i] = a[i] + a[i + 1];
                    a[i + 1] = a[i] - a[i + 1];
                    a[i] = a[i] - a[i + 1];
                }
            }
            high--;//修改high值，迁移一位
            for (int j = high; j > low; j--) {//反向排序，找到最小值
                if (a[j] < a[j - 1]) {
                    a[j] = a[j] + a[j - 1];
                    a[j - 1] = a[j] - a[j - 1];
                    a[j] = a[j] - a[j - 1];
                }
            }
            low++;//修改low值，后移一位
        }
    }
}
