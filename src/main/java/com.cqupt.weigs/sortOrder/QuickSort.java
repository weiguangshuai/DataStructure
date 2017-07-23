package com.cqupt.weigs.sortOrder;

/**
 * 快速排序
 * @author weigs
 * @date 2017/7/3 0003
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 5, 2, 23, 5, 675, 34, 54, 6, 5, 45, 4, 554, 34, 43, 123, 2, 32, 21, 12};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    public static int getMiddle(int[] a, int low, int high) {

        int key = a[low];//基准元素，排序中会空出来一个位置
        while (low < high) {
            while (low < high && a[high] >= key) {//从high开始找比基准小的，与low换位置
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= key) {//从low开始找比基准大,放到之前high空出来的位置
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;//此时low=high 是基准元素的位置，也是空出来的那个位置
        return low;
    }
}
