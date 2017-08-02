package com.cqupt.weigs.Link;

/**
 * @author weigs
 * @date 2017/7/26 0026
 */
public class SeqListDemo {
    public static void main(String[] args) {
        SeqList<Integer> seqList = new SeqList<>();
        seqList.add(0);
        seqList.add(1);
        seqList.add(8);
        seqList.print();
        seqList.remove(1);
        System.out.println();
        seqList.print();
    }
}
