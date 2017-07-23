package com.cqupt.weigs.sortOrder;

/**
 * 简单选择排序
 *
 * @author weigs
 * @date 2017/6/29 0029
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int a[] = {1, 23, 5, 6, 34, 34, 54, 3, 3, 2, 5, 46, 6755, 23};
        SimpleSelectSort simpleSelectSort = new SimpleSelectSort();
        System.out.println("初始值:");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n排序后：");
        simpleSelectSort.selectSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;//k存放最小值下标，每次循环最小值加1
            for (int j = i + 1; j < a.length; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }
            }
            swap(a, k, i);
        }
    }

    private void swap(int[] a, int k, int i) {
        if (i == k) {
            return;
        }
        a[i] = a[i] + a[k];
        a[k] = a[i] - a[k];
        a[i] = a[i] - a[k];
    }

    //二元选择排序，对简单选择排序的改进
    private void binarySelectSort(int[] a, int n) {
        int i, j, min, max, tmp;
        for (i = 1; i <= n / 2; i++) {
            //做不超过n/2趟选择排序
            min = i;
            max = i;//分别记录最大和最小关键字记录位置
            for (j = i + 1; j <= n - i; j++) {
                if (a[j] > a[max]) {
                    max = j;
                    continue;
                }
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //该交换操作还可分情况讨论以提高效率
            tmp = a[i - 1];
            a[i - 1] = a[min];
            a[min] = tmp;
            tmp = a[n - i];
            a[n - i] = a[max];
            a[max] = tmp;
        }
    }
}
