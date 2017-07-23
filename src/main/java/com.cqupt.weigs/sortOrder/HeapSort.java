package com.cqupt.weigs.sortOrder;

import java.util.Random;

/**
 * 堆排序
 * <p>
 * 两个步骤：1、建堆 2、对顶与堆的最后一个元素交换位置
 *
 * @author weigs
 * @date 2017/7/10 0010
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] a = new int[50000];
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            a[i] = random.nextInt();
        }
        /*
        System.out.println("初始值:");
        for (int i : a) {
            System.out.print(i + " ");
        }
        */

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            createLittleHeap(a, a.length - 1 - i);
            swap(a, 0, a.length - 1 - i);
        }
        /*
        System.out.println("\n排序后：");
        for (int b : a) {
            System.out.print(b + " ");
        }
        */
        long endTime = System.currentTimeMillis();
        System.out.println("\n总的用时：" + (endTime - startTime));
    }

    /*
      创建小顶堆：双亲节点小与子节点的值，从叶子节点开始，直到根节点。这样建立的堆定位最小值
     */
    private static void createLittleHeap(int[] data, int last) {
        //找到最后一个叶子节点的双亲节点
        for (int i = (last - 1) / 2; i >= 0; i--) {
            //保存当前正在判断的节点
            int parent = i;
            //若当前节点的子节点存在
            if (2 * parent + 1 <= last) {
                //biggerindex总是记录交大节点的值
                int bigger = 2 * parent + 1;//bigger指向左节点
                if (bigger < last) { //说明存在右节点
                    if (data[bigger] > data[bigger + 1]) {
                        bigger = bigger + 1;
                    }
                }
                if (data[parent] > data[bigger]) {
                    //若双亲节点的值大于子节点的最大值，则交换
                    swap(data, parent, bigger);
//                    parent = bigger;
                }
            }
        }
    }


    public static void swap(int[] data, int i, int j) {
        if (i == j)
            return;
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    //书上c语言描述过程
    public static void sift(int r[], int low, int high) {
        int i = low, j = 2 * i;
        int tmp = r[i];
        while (j <= high) {
            if (j < high && r[j] < r[j + 1]) {
                j++;
            }
            if (tmp < r[j]) {
                r[i] = r[j];
                i = j;
                j = 2 * i;
            } else
                break;
        }
        r[i] = tmp;
    }

}
