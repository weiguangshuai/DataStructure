package com.cqupt.weigs.linearTable;

/**
 * @author weigs
 * @date 17-5-11
 */
public class SequenceListDemo {
    public static void main(String[] args) {
        SequenceList<Integer> sequenceList = new SequenceList<>();
        sequenceList.add(1);
        int len = sequenceList.length();
        System.out.println(len);
    }
}
