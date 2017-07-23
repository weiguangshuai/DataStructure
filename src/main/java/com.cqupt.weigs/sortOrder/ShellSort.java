package com.cqupt.weigs.sortOrder;


/**
 * 希尔排序
 *
 * @author weigs
 * @date 2017/6/29 0029
 */
public class ShellSort {

    public static void main(String[] args) {
        int a[] = {1, 24, 52, 3, 2, 5, 65, 23, 543, 6543, 31, 65, 34, 53423, 321};
        ShellSort shellSort = new ShellSort();
        System.out.println("初始值:");
        for (int i : a) {
            System.out.print(i + " ");
        }
        shellSort.shellSort(a);
        System.out.println("\n排序后：");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellInsertSort(a, dk);
            dk = dk / 2;
        }
    }

    private void shellInsertSort(int a[], int dk) {//类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                int x = a[i];//x为待插入的数
                for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = x;//插入
            }
        }
    }
}
